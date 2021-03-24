package com.example.study.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor // 모든 생성자.
@NoArgsConstructor // 기본 생성자
@Entity
@ToString(exclude = {"orderDetailList", "partner"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class Item {
    @Id // index column을 나타냄.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String name;

    private String title;

    private String content;

    private Integer price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item") // Item 1 : N OrderDetail
    private List<OrderDetail> orderDetailList;

    // Item N : 1 Partner
    @ManyToOne
    private Partner partner;


    /*
    //1:N
    // LAZY = 지연 로딩, EAGER = 즉시 로딩
    // LAZY = SELECT * FROM item where id = ?
    // EAGER : 연관관계가 설정된 모든 테이블에서 JOIN이 발생한다. => 성능 저하, 모든 것을 가지고 오지 못할 위험이 있다.
    // item_id = order_derail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
     */
}

