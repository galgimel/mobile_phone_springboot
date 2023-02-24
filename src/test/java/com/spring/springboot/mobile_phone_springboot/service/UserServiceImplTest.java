package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.entity.User;
import com.spring.springboot.mobile_phone_springboot.repository.UserRepository;
import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import com.spring.springboot.mobile_phone_springboot.response.UserResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @MockBean private UserRepository userRepository;
    @Autowired private UserService userService;

    MobilePhoneResponse mobilePhoneResponse =
        MobilePhoneResponse.builder()
            .brand("No")
            .model("Phone")
            .build();
    @Test
    public void getAllUsers() {
        List<User> users = List.of(
            new User(1,"Lilya", "Brick", 34, null),
            new User(2,"Artemiy", "Lebedev", 41, null),
            new User(3,"Vladimir", "Mayakovskiy", 36, null)
            );

        Mockito.when(userRepository.findAll()).thenReturn(users);
        List<UserResponse> actual = userService.getAllUsers();
        List<UserResponse> expected = List.of(
            new UserResponse(1,"Lilya", "Brick", 34, mobilePhoneResponse),
            new UserResponse(2,"Artemiy", "Lebedev", 41, mobilePhoneResponse),
            new UserResponse(3,"Vladimir", "Mayakovskiy", 36, mobilePhoneResponse)
        );

        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i).getId(), actual.get(i).getId());
            Assert.assertEquals(expected.get(i).getName(), actual.get(i).getName());
            Assert.assertEquals(expected.get(i).getSurname(), actual.get(i).getSurname());
            Assert.assertEquals(expected.get(i).getAge(), actual.get(i).getAge());
            Assert.assertEquals(expected.get(i).getMobilePhoneResponse().getId(), actual.get(i).getMobilePhoneResponse().getId());
            Assert.assertEquals(expected.get(i).getMobilePhoneResponse().getBrand(), actual.get(i).getMobilePhoneResponse().getBrand());
            Assert.assertEquals(expected.get(i).getMobilePhoneResponse().getModel(), actual.get(i).getMobilePhoneResponse().getModel());
            Assert.assertEquals(expected.get(i).getMobilePhoneResponse().getPerformance(), actual.get(i).getMobilePhoneResponse().getPerformance());
            Assert.assertEquals(expected.get(i).getMobilePhoneResponse().getPrice(), actual.get(i).getMobilePhoneResponse().getPrice());
        }
    }

    @Test
    public void getUser() {
        int id = 3;
        User user = new User(id,"Vladimir", "Mayakovskiy", 36, null);
        Mockito.when(userRepository.getReferenceById(id)).thenReturn(user);
        UserResponse actual = userService.getUser(id);
        UserResponse expected = new UserResponse(3,"Vladimir", "Mayakovskiy", 36, mobilePhoneResponse);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getSurname(), actual.getSurname());
        Assert.assertEquals(expected.getAge(), actual.getAge());
        Assert.assertEquals(expected.getMobilePhoneResponse().getId(), actual.getMobilePhoneResponse().getId());
        Assert.assertEquals(expected.getMobilePhoneResponse().getBrand(), actual.getMobilePhoneResponse().getBrand());
        Assert.assertEquals(expected.getMobilePhoneResponse().getModel(), actual.getMobilePhoneResponse().getModel());
        Assert.assertEquals(expected.getMobilePhoneResponse().getPerformance(), actual.getMobilePhoneResponse().getPerformance());
        Assert.assertEquals(expected.getMobilePhoneResponse().getPrice(), actual.getMobilePhoneResponse().getPrice());
    }
}