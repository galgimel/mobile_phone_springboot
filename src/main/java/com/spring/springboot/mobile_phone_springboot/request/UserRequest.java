package com.spring.springboot.mobile_phone_springboot.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserRequest {
    private final int id;
    @NonNull
    private final String name;
    @NonNull
    private final String surname;
    private final int age;
    private int mobilePhoneId;

}
