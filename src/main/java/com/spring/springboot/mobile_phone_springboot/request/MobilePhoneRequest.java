package com.spring.springboot.mobile_phone_springboot.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class MobilePhoneRequest {
    private final int id;
    @NotBlank
    @Size(min = 1, max = 20)
    private final String brand;
    @NotBlank
    @Size(min = 1, max = 20)
    private final String model;
    @NotBlank
    @Size(min = 1, max = 15)
    private final int performance;
    @NotBlank
    @Size(min = 1)
    private final int price;
}
