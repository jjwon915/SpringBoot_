package com.example.study.repository;

import com.example.study.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Type에 대해서 찾아오겠다. : select * from category where type = ?;
    Optional<Category> findByType(String type);

}
