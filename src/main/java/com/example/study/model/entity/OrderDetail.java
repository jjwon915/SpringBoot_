package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //order_detail table과 자동적으로 연결됨.
@ToString(exclude = {"orderGroup", "item"}) // : 연관관계 설정에 대한 변수는 exclude해주는 것이 좋다.
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    @ManyToOne
    private OrderGroup orderGroup;

    @ManyToOne
    private Item item;



    /*
    @ManyToOne // OrderDetail의 입장에서 자신은 N.(user와 orderDetail은 1:M관계)
    private User user;

    // N : 1
    @ManyToOne
    private Item item;
     */
}
