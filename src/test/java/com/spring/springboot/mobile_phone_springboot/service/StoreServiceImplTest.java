package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.entity.Store;
import com.spring.springboot.mobile_phone_springboot.repository.MobilePhoneRepository;
import com.spring.springboot.mobile_phone_springboot.repository.StoreRepository;
import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class StoreServiceImplTest {
    @MockBean
    private StoreRepository storeRepository;
    @MockBean
    private MobilePhoneRepository mobilePhoneRepository;
    @Autowired
    private StoreService storeService;

    @Test
    void getAllMobilePhonesInStore() {
        int storeID = 4;
        Store store = new Store(storeID, "SonyStore", null);
        MobilePhone mp1 = new MobilePhone(
            1, "Sony", "ExtraOne", 9, 1500, null, List.of(store)
        );
        MobilePhone mp2 = new MobilePhone(
            2, "Sony", "ExtraTwo", 8, 1300, null, List.of(store)
        );
        MobilePhone mp3 = new MobilePhone(
            3, "Sony", "ExtraThree", 7, 1100, null, List.of(store)
        );
        List<MobilePhone> mobilePhonesFromStore = List.of(mp1, mp2, mp3);
        store.setMobilePhones(mobilePhonesFromStore);

        Mockito.when(storeRepository.findById(storeID)).thenReturn(Optional.of(store));

        List<MobilePhoneResponse> actual = storeService.getAllMobilePhonesInStore(storeID);
        List<MobilePhoneResponse> expected = List.of(
            new MobilePhoneResponse(1, "Sony", "ExtraOne", 9, 1500),
            new MobilePhoneResponse(2, "Sony", "ExtraTwo", 8, 1300),
            new MobilePhoneResponse(3, "Sony", "ExtraThree", 7, 1100)
        );
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAllMobilePhonesOutOfStore() {
        int storeID = 4;
        Store store = new Store(storeID, "SonyStore", null);
        MobilePhone mp1 = new MobilePhone(
            1, "Sony", "ExtraOne", 9, 1500, null, List.of(store)
        );
        MobilePhone mp2 = new MobilePhone(
            2, "Sony", "ExtraTwo", 8, 1300, null, List.of(store)
        );
        MobilePhone mp3 = new MobilePhone(
            3, "Sony", "ExtraThree", 7, 1100, null, List.of(store)
        );
        MobilePhone mp4 = new MobilePhone(
            4, "Apple", "14PRO", 10, 1900, null, null
        );
        MobilePhone mp5 = new MobilePhone(
            5, "Apple", "14", 9, 1700, null, null
        );
        List<MobilePhone> mobilePhonesFromStore = List.of(mp1, mp2, mp3);
        List<MobilePhone> allMobilePhones = List.of(mp1, mp2, mp3, mp4, mp5);
        store.setMobilePhones(mobilePhonesFromStore);

        Mockito.when(mobilePhoneRepository.findAll()).thenReturn(allMobilePhones);
        Mockito.when(storeRepository.findById(storeID)).thenReturn(Optional.of(store));

        List<MobilePhoneResponse> actual = storeService.getAllMobilePhonesOutOfStore(storeID);
        List<MobilePhoneResponse> expected = List.of(
            new MobilePhoneResponse(4, "Apple", "14PRO", 10, 1900),
            new MobilePhoneResponse(5, "Apple", "14", 9, 1700)
        );
        Assertions.assertEquals(expected, actual);
    }
}