package com.spring.springboot.mobile_phone_springboot.entity;

import javax.persistence.*;

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

    public MobilePhone() {}

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

    @Override
    public String toString() {
        return "MobilePhone{" +
            "id=" + id +
            ", brand='" + brand + '\'' +
            ", model='" + model + '\'' +
            ", performance=" + performance +
            ", price=" + price +
            '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
