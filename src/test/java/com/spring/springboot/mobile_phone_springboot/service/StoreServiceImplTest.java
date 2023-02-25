package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.repository.MobilePhoneRepository;
import com.spring.springboot.mobile_phone_springboot.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class StoreServiceImplTest {
    @MockBean private StoreRepository storeRepository;
    @MockBean private MobilePhoneRepository mobilePhoneRepository;

    @Autowired private StoreService storeService;
    @Test
    void getAllMobilePhonesInStore() {
    }

    @Test
    void getAllMobilePhonesOutOfStore() {
    }
}
