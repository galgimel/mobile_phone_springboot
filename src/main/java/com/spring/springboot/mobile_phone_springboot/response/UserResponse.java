package com.spring.springboot.mobile_phone_springboot.response;

import com.spring.springboot.mobile_phone_springboot.entity.User;
import lombok.*;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserResponse)) return false;
        UserResponse that = (UserResponse) o;
        return getId() == that.getId()
            && getAge() == that.getAge()
            && getName().equals(that.getName())
            && getSurname().equals(that.getSurname())
            && getMobilePhoneResponse().equals(that.getMobilePhoneResponse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getAge(), getMobilePhoneResponse());
    }
}
