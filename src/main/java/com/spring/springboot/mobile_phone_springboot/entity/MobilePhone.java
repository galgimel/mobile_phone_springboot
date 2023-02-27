package com.spring.springboot.mobile_phone_springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH
        },
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "users_mobile_phone_id")
    private List<User> users;
    @ManyToMany(
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH
        }
    )
    @JoinTable(
        name = "mobile_phone_store",
        joinColumns = @JoinColumn(name = "mobile_phone_id"),
        inverseJoinColumns = @JoinColumn(name = "store_id")
    )
    private List<Store> stores;


}