package com.spring.springboot.mobile_phone_springboot.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class UserRequest {
    private final int id;
    @NotBlank
    @Size(min = 1, max = 20)
    private final String name;
    @NotBlank
    @Size(min = 1, max = 20)
    private final String surname;
    @NotBlank
    @Size(min = 1, max = 100)
    private final int age;
    private int mobilePhoneId;

}
