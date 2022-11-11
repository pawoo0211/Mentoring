package com.example.mentoring.menu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "menu")
@Entity
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long menuId;

    @Column(name = "menu")
    private String menu;

    @Column(name = "price")
    private int price;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Builder
    public MenuEntity(String menu, int price) {
        this.menu = menu;
        this.price = price;
    }
}
