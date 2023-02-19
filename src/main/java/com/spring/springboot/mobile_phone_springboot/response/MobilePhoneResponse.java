package com.spring.springboot.mobile_phone_springboot.response;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MobilePhoneResponse {
    private final int id;
    private final String brand;
    private final String model;
    private final int performance;
    private final int price;
    public static MobilePhoneResponse getMobilePhoneResponse(final MobilePhone mobilePhone) {
        return MobilePhoneResponse.builder()
            .id(mobilePhone.getId())
            .brand(mobilePhone.getBrand())
            .model(mobilePhone.getModel())
            .performance(mobilePhone.getPerformance())
            .price(mobilePhone.getPrice())
            .build();
    }
    @Override
    public String toString() {
        return brand + " " + model;
    }
}
