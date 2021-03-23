package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor // 모든 생성자.
@NoArgsConstructor // 기본 생성자
@Entity
public class Item {
    @Id // index column을 나타냄.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    private String content;

    //1:N
    // LAZY = 지연 로딩, EAGER = 즉시 로딩
    // LAZY = SELECT * FROM item where id = ?
    // EAGER : 연관관계가 설정된 모든 테이블에서 JOIN이 발생한다. => 성능 저하, 모든 것을 가지고 오지 못할 위험이 있다.
    // item_id = order_derail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;

}

