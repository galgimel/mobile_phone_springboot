package com.spring.springboot.mobile_phone_springboot.response;

import com.spring.springboot.mobile_phone_springboot.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class UserResponse {
    private final int id;
    private final String name;
    private final String surname;
    private final int age;
    private MobilePhoneResponse mobilePhoneResponse;

    public static UserResponse of(final User user) {
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
                    .build()
            );
        } else {
            userResponse.setMobilePhoneResponse(MobilePhoneResponse.of(user.getUsersMobilePhone()));
        }
        return userResponse;
    }
}
