package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.entity.User;
import com.spring.springboot.mobile_phone_springboot.repository.UserRepository;
import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import com.spring.springboot.mobile_phone_springboot.response.UserResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
public class UserServiceImplTest {
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    MobilePhoneResponse mobilePhoneResponse =
        MobilePhoneResponse.builder()
            .brand("No")
            .model("Phone")
            .build();

    @Test
    public void getAllUsers() {
        List<User> users = List.of(
            new User(1, "Lilya", "Brick", 34, null),
            new User(2, "Artemiy", "Lebedev", 41, null),
            new User(3, "Vladimir", "Mayakovskiy", 36, null)
        );

        Mockito.when(userRepository.findAll()).thenReturn(users);
        List<UserResponse> actual = userService.getAllUsers();
        List<UserResponse> expected = List.of(
            new UserResponse(1, "Lilya", "Brick", 34, mobilePhoneResponse),
            new UserResponse(2, "Artemiy", "Lebedev", 41, mobilePhoneResponse),
            new UserResponse(3, "Vladimir", "Mayakovskiy", 36, mobilePhoneResponse)
        );

        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void getUser() {
        int id = 3;
        User user = new User(id, "Vladimir", "Mayakovskiy", 36, null);
        Mockito.when(userRepository.getReferenceById(id)).thenReturn(user);
        UserResponse actual = userService.getUser(id);
        UserResponse expected = new UserResponse(3, "Vladimir", "Mayakovskiy", 36, mobilePhoneResponse);

        Assertions.assertEquals(expected, actual);
    }
}