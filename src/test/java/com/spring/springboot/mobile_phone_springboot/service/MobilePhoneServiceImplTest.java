package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.repository.MobilePhoneRepository;
import com.spring.springboot.mobile_phone_springboot.request.MobilePhoneRequest;
import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
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

        Mockito.when(mobilePhoneRepository.findById(null)).thenReturn(Optional.of(mobilePhone));
        Mockito.when(mobilePhoneRepository.save(mobilePhone)).thenReturn(mobilePhone);

        MobilePhoneResponse actual = mobilePhoneService.saveMobilePhone(mobilePhoneRequest);
        MobilePhoneResponse expected = new MobilePhoneResponse(
            0, "Sony", "ExtraOne", 8, 1300
        );

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getBrand(), actual.getBrand());
        Assert.assertEquals(expected.getModel(), actual.getModel());
        Assert.assertEquals(expected.getPerformance(), actual.getPerformance());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
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

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getBrand(), actual.getBrand());
        Assert.assertEquals(expected.getModel(), actual.getModel());
        Assert.assertEquals(expected.getPerformance(), actual.getPerformance());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
    }
}