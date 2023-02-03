package com.spring.springboot.mobile_phone_springboot.entity;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "mobile_phones")
public class MobilePhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "performance")
    private int performance;
    @Column(name = "price")
    private int price;

    public MobilePhone(String brand, String model, int performance, int price) {
        this.brand = brand;
        this.model = model;
        this.performance = performance;
        this.price = price;
    }
    public MobilePhone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

}
