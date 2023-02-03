package com.spring.springboot.mobile_phone_springboot.response;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class MobilePhoneResponse {
    private int id;
    private String brand;
    private String model;
    private int performance;
    private int price;
}
