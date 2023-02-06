package com.spring.springboot.mobile_phone_springboot.response;

import com.spring.springboot.mobile_phone_springboot.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UserResponse {
    private int id;
    private String name;
    private String surname;
    private int age;
    private Integer mobilePhoneId;
    public static UserResponse getUserResponse(User user) {
        return UserResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .surname(user.getSurname())
            .age(user.getAge())
            .mobilePhoneId(user.getMobilePhoneId())
            .build();
    }
}
