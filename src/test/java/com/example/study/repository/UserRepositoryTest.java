package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import com.sun.tools.javac.util.Assert;
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
        // 쿼리문을 통해 아래와 같이 DB관리하지 않음.
        // String sql = insert into user (%s, %s %d) value (account, email, age);

        // JPA를 통해 객체를 가지고 db 관리.
        User user = new User();
        // Id는 auto increment 이므로 쓰지 않는다.
        user.setAccount("TestUser03");
        user.setEmail("testUser03@gmail.com");
        user.setPhoneNumber("010-3333-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser3");

        // save Method는 user를 저장하고 newUser를 받는다.
        User newUser =  userRepository.save(user);
        System.out.println("newUser : "  +newUser);
    }

    @Test
    public void read(){
        // 2번 Id 가진 user출력.
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser->{
            System.out.println("user : " +selectUser);
            System.out.println("email : " +selectUser.getEmail());
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
