package com.spring.springboot.mobile_phone_springboot.rest_controller;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.entity.User;
import com.spring.springboot.mobile_phone_springboot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserRestControllerTest {
    @MockBean private UserRepository userRepository;
    @Autowired private MockMvc mockMvc;

    @Test
    void showAllUsers() throws Exception {
        MobilePhone mobilePhone1 = new MobilePhone(
            1, "Sony", "ExtraOne", 9, 1500, null, null
        );
        MobilePhone mobilePhone2 = new MobilePhone(
            2, "Apple", "14", 9, 1700, null, null
        );
        List<User> users = List.of(
            new User(1, "Lilya", "Brick", 34, mobilePhone1),
            new User(3, "Vladimir", "Mayakovskiy", 36, mobilePhone2)
        );

        Mockito.when(userRepository.findAll()).thenReturn(users);
        mockMvc.perform(get("/api/v1/users"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].id", equalTo(1)))
            .andExpect(jsonPath("$[0].name", equalTo("Lilya")))
            .andExpect(jsonPath("$[0].surname", equalTo("Brick")))
            .andExpect(jsonPath("$[0].age", equalTo(34)))
            .andExpect(jsonPath("$[0].mobilePhoneResponse.id", equalTo(1)))
            .andExpect(jsonPath("$[0].mobilePhoneResponse.brand", equalTo("Sony")))
            .andExpect(jsonPath("$[0].mobilePhoneResponse.model", equalTo("ExtraOne")))
            .andExpect(jsonPath("$[0].mobilePhoneResponse.performance", equalTo(9)))
            .andExpect(jsonPath("$[0].mobilePhoneResponse.price", equalTo(1500)))
            .andExpect(jsonPath("$[1].id", equalTo(3)))
            .andExpect(jsonPath("$[1].name", equalTo("Vladimir")))
            .andExpect(jsonPath("$[1].surname", equalTo("Mayakovskiy")))
            .andExpect(jsonPath("$[1].age", equalTo(36)))
            .andExpect(jsonPath("$[1].mobilePhoneResponse.id", equalTo(2)))
            .andExpect(jsonPath("$[1].mobilePhoneResponse.brand", equalTo("Apple")))
            .andExpect(jsonPath("$[1].mobilePhoneResponse.model", equalTo("14")))
            .andExpect(jsonPath("$[1].mobilePhoneResponse.performance", equalTo(9)))
            .andExpect(jsonPath("$[1].mobilePhoneResponse.price", equalTo(1700)));
    }

    @Test
    void getUser() throws Exception {
        MobilePhone mobilePhone = new MobilePhone(
            1, "Apple", "14", 9, 1700, null, null
        );
        User user = new User(3, "Vladimir", "Mayakovskiy", 36, mobilePhone);

        Mockito.when(userRepository.getReferenceById(anyInt())).thenReturn(user);
        mockMvc.perform(get("/api/v1/users/3"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", equalTo(3)))
            .andExpect(jsonPath("$.name", equalTo("Vladimir")))
            .andExpect(jsonPath("$.surname", equalTo("Mayakovskiy")))
            .andExpect(jsonPath("$.age", equalTo(36)))
            .andExpect(jsonPath("$.mobilePhoneResponse.id", equalTo(1)))
            .andExpect(jsonPath("$.mobilePhoneResponse.brand", equalTo("Apple")))
            .andExpect(jsonPath("$.mobilePhoneResponse.model", equalTo("14")))
            .andExpect(jsonPath("$.mobilePhoneResponse.performance", equalTo(9)))
            .andExpect(jsonPath("$.mobilePhoneResponse.price", equalTo(1700)));
    }
}