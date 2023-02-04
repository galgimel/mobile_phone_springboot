package com.spring.springboot.mobile_phone_springboot.response;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
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
    public static MobilePhoneResponse getResponse(MobilePhone mobilePhone) {
        return MobilePhoneResponse.builder()
            .id(mobilePhone.getId())
            .brand(mobilePhone.getBrand())
            .model(mobilePhone.getModel())
            .performance(mobilePhone.getPerformance())
            .price(mobilePhone.getPrice())
            .build();
    }
}
