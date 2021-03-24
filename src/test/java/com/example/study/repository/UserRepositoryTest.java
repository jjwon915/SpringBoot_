package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired // Dependency Injection(DI) : Aurowired를 통해 사용. 직접 객체를 만들지 않고 Spring이 직접 관리.
    private UserRepository userRepository;

    @Test
    public void create(){
        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gamil.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);

        Assertions.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
        System.out.println("------------조회--------------");
        System.out.println("계정 : " + user.getAccount());

        user.getOrderGroupList().stream().forEach(orderGroup -> {
            System.out.println("------------주문 묶음-------------");
            System.out.println("수령인 : " +orderGroup.getRevName());
            System.out.println("수령지 : " +orderGroup.getRevAddress());
            System.out.println("총금액 : " +orderGroup.getTotalPrice());
            System.out.println("총수량 : " +orderGroup.getTotalQuantity());
            System.out.println("------------주문 상세-------------");

            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("파트너사 이름 : " +orderDetail.getItem().getPartner().getName());
                System.out.println("파트너사 카테고리 : " +orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문 상품 : " +orderDetail.getItem().getName());
                System.out.println("고객센터 번호 : " +orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문의 상태 : " +orderDetail.getStatus());
                System.out.println("도착예정일자 : " +orderDetail.getArrivalDate());
            });
        });

    }

    @Test
    public void update(){
        // Update를 위해서는 특정 user를 먼저 select해야함.
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser ->{
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });

    }

    @Test
    @Transactional // delete query를 실행하더라도 rollback 시켜 데이터를 원래상태로 돌려놓는다.
    public void delete(){
        Optional<User> user = userRepository.findById(3L);

        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        //Assert.assertFalse(user.isPresent());

        if(deleteUser.isPresent()){
            System.out.println("데이터 존재 :" +deleteUser.get());
        }
        else{
            System.out.println("데이터 없음");
        }
    }
}
