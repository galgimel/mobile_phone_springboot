package com.spring.springboot.mobile_phone_springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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
    @OneToMany(
        cascade = {CascadeType.PERSIST,
        CascadeType.MERGE,
        CascadeType.REFRESH,
        CascadeType.DETACH},
        mappedBy = "usersMobilePhone",
        fetch = FetchType.LAZY)
    private List<User> users;
}
