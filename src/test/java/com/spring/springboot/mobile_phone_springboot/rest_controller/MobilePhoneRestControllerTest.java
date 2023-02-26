package com.spring.springboot.mobile_phone_springboot.rest_controller;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.repository.MobilePhoneRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MobilePhoneRestControllerTest {

    @MockBean private MobilePhoneRepository mobilePhoneRepository;
    @Autowired private MockMvc mockMvc;


    @Test
    void showAllMobilePhones() throws Exception {
        List<MobilePhone> mobilePhones = List.of(
        new MobilePhone(1, "Sony", "ExtraOne", 9, 1500, null, null),
        new MobilePhone(5, "Apple", "14", 9, 1700, null, null)
        );
        Mockito.when(mobilePhoneRepository.findAll()).thenReturn(mobilePhones);
        mockMvc.perform(get("/api/v1/mobile_phones"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$",hasSize(2)))
            .andExpect(jsonPath("$[*].id", containsInAnyOrder(1,5)))
            .andExpect(jsonPath("$[*].brand", containsInAnyOrder("Sony", "Apple")))
            .andExpect(jsonPath("$[*].model", containsInAnyOrder("ExtraOne", "14")))
            .andExpect(jsonPath("$[*].performance", containsInAnyOrder(9, 9)))
            .andExpect(jsonPath("$[*].price", containsInAnyOrder(1500, 1700)));
    }

    @Test
    void getMobilePhone() throws Exception {
        MobilePhone mobilePhone = new MobilePhone(
            1, "Apple", "14", 9, 1700, null, null
        );

        Mockito.when(mobilePhoneRepository.getReferenceById(anyInt())).thenReturn(mobilePhone);
        mockMvc.perform(get("/api/v1/mobile_phones/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", equalTo(1)))
            .andExpect(jsonPath("$.brand", equalTo("Apple")))
            .andExpect(jsonPath("$.model", equalTo("14")))
            .andExpect(jsonPath("$.performance", equalTo(9)))
            .andExpect(jsonPath("$.price", equalTo(1700)));
    }
}