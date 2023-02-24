package com.spring.springboot.mobile_phone_springboot.request;

import lombok.*;
import org.springframework.lang.NonNull;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class MobilePhoneRequest {
    private final int id;
    @NonNull
    private final String brand;
    @NonNull
    private final String model;
    private final int performance;
    private final int price;
}
