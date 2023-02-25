package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.repository.MobilePhoneRepository;
import com.spring.springboot.mobile_phone_springboot.request.MobilePhoneRequest;
import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
class MobilePhoneServiceImplTest {

    @MockBean
    private MobilePhoneRepository mobilePhoneRepository;
    @Autowired
    private MobilePhoneService mobilePhoneService;

    @Test
    void addNewMobilePhone() {
        MobilePhone mobilePhone = new MobilePhone();
        MobilePhoneRequest mobilePhoneRequest =
            MobilePhoneRequest.builder()
                .brand("Sony")
                .model("ExtraOne")
                .performance(8)
                .price(1300)
                .build();

        Mockito.when(mobilePhoneRepository.save(mobilePhone)).thenReturn(mobilePhone);

        MobilePhoneResponse actual = mobilePhoneService.saveMobilePhone(mobilePhoneRequest);
        MobilePhoneResponse expected = new MobilePhoneResponse(
            0, "Sony", "ExtraOne", 8, 1300
        );

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void updateMobilePhone() {
        int id = 1;
        MobilePhone mobilePhone = new MobilePhone(
            id, "Sony", "ExtraOne", 8, 1500, null, null
        );
        MobilePhoneRequest mobilePhoneRequest = new MobilePhoneRequest(
            id, "Sony", "ExtraOne", 8, 1300
        );

        Mockito.when(mobilePhoneRepository.findById(id)).thenReturn(Optional.of(mobilePhone));
        Mockito.when(mobilePhoneRepository.save(mobilePhone)).thenReturn(mobilePhone);

        MobilePhoneResponse actual = mobilePhoneService.saveMobilePhone(mobilePhoneRequest);
        MobilePhoneResponse expected = new MobilePhoneResponse(
            id, "Sony", "ExtraOne", 8, 1300
        );

        Assertions.assertEquals(expected, actual);
    }
}