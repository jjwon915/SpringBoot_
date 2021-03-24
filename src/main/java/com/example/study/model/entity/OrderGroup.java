package com.example.study.model.entity;

import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = {"user", "orderGroup"})
public class OrderGroup {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String status;
    
    private String orderType; // 주문의 형태 - 일괄 / 개별
    
    private String revAddress;
    
    private String revName;
    
    private String paymentType; // 카드 / 현금 결제 구분
    
    private BigDecimal totalPrice;
    
    private Integer totalQuantity;
    
    private LocalDateTime orderAt;
    
    private LocalDateTime arrivalDate;
    
    private LocalDateTime createdAt;
    
    private String createdBy;
    
    private LocalDateTime updatedAt;
    
    private String updatedBy;

    // OrderGroup N : 1 User --> userId를 아래 User Type의 user로 바꾼다.
    @ManyToOne
    private User user;

    // OrderGroup 1 : N OrderDetail
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;


}
