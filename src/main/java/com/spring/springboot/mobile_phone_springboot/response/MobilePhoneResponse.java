package com.spring.springboot.mobile_phone_springboot.response;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MobilePhoneResponse {
    private final int id;
    private final String brand;
    private final String model;
    private final int performance;
    private final int price;
    public static MobilePhoneResponse of(final MobilePhone mobilePhone) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MobilePhoneResponse)) return false;
        MobilePhoneResponse that = (MobilePhoneResponse) o;
        return getId() == that.getId()
            && getPerformance() == that.getPerformance()
            && getPrice() == that.getPrice()
            && getBrand().equals(that.getBrand())
            && getModel().equals(that.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getPerformance(), getPrice());
    }
}
