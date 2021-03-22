package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

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

    public void read(){

    }

    public void update(){

    }

    public void delete(){

    }
}
