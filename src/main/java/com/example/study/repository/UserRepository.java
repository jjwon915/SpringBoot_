package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Long : User Entity의 Id값을 Long으로 했기 때문. 기본키 인덱스는 Long Type을 의미함.
}
