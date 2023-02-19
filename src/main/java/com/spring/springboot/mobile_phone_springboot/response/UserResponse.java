package com.spring.springboot.mobile_phone_springboot.response;

import com.spring.springboot.mobile_phone_springboot.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class UserResponse {
    private final int id;
    private final String name;
    private final String surname;
    private final int age;
    private MobilePhoneResponse mobilePhoneResponse;

    public static UserResponse getUserResponse(final User user) {
        UserResponse userResponse = UserResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .surname(user.getSurname())
            .age(user.getAge())
            .build();
        if (user.getUsersMobilePhone() == null) {
            userResponse.setMobilePhoneResponse(
                MobilePhoneResponse.builder()
                    .brand("No")
                    .model("Phone")
                    .build());
        } else {
            userResponse.setMobilePhoneResponse(
                MobilePhoneResponse
                    .getMobilePhoneResponse
                        (user.getUsersMobilePhone()));
        }
        return userResponse;
    }
}
