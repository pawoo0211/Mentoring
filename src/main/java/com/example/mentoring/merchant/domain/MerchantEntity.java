package com.example.mentoring.merchant.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "merchants")
@Entity
public class MerchantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "merchant_id")
    private Long merchantId;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column
    private String name;

    @Column(name = "opening_hours")
    private LocalTime openingHours;

    @Column(name = "closed_hours")
    private LocalTime closedHours;

    @Builder
    public MerchantEntity(String name, LocalTime openingHours, LocalTime closedHours){
        this.name = name;
        this.openingHours = openingHours;
        this.closedHours = closedHours;
    }
}
