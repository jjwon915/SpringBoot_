package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends StudyApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);
        Assertions.assertNotNull(newCategory);
        Assertions.assertEquals(newCategory.getType(), type);
        Assertions.assertEquals(newCategory.getTitle(), title);

    }

    @Test
    public void read(){
        String type = "COMPUTER";

        //CategoryRepository 에 생성한 Type 을 통해 찾아오는 쿼리 method 를 통해 읽어오도록 함.
        Optional<Category> optionalCategory = categoryRepository.findByType("COMPUTER");

        // select * from category where type = 'COMPUTER';

        optionalCategory.ifPresent(i->{
            Assertions.assertEquals(i.getType(), type);
            System.out.println(i.getId());
            System.out.println(i.getType());
            System.out.println(i.getTitle());
        });

    }

}
