package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

// DB의 Table 이름과 동일하게 생성한다면 @Table(name="user")안써도 됨.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // == table
//@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name="account") : 변수명과 Column명이 동일하면 작성하지 않아도 된다.
    private Long id;

    private String account;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

}
