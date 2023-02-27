package com.spring.springboot.mobile_phone_springboot.rest_controller;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.entity.Store;
import com.spring.springboot.mobile_phone_springboot.repository.MobilePhoneRepository;
import com.spring.springboot.mobile_phone_springboot.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StoreRestControllerTest {
    @MockBean private StoreRepository storeRepository;
    @MockBean private MobilePhoneRepository mobilePhoneRepository;
    @Autowired private MockMvc mockMvc;

    @Test
    void showAllStores() throws Exception {
        List<Store> stores = List.of(
            new Store(1, "Sony", null),
            new Store(2, "Apple Store", null)
        );

        Mockito.when(storeRepository.findAll()).thenReturn(stores);
        mockMvc.perform(get("/api/v1/stores"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].id", equalTo(1)))
            .andExpect(jsonPath("$[0].name", equalTo("Sony")))
            .andExpect(jsonPath("$[1].id", equalTo(2)))
            .andExpect(jsonPath("$[1].name", equalTo("Apple Store")));
    }

    @Test
    void showAllMobilePhonesInStore() throws Exception {
        Store store = new Store(4, "SonyStore", null);
        MobilePhone mp1 = new MobilePhone(
            1, "Sony", "ExtraOne", 9, 1500, null, List.of(store)
        );
        MobilePhone mp2 = new MobilePhone(
            2, "Sony", "ExtraTwo", 8, 1300, null, List.of(store)
        );
        List<MobilePhone> mobilePhonesFromStore = List.of(mp1, mp2);
        store.setMobilePhones(mobilePhonesFromStore);

        Mockito.when(storeRepository.findById(anyInt())).thenReturn(Optional.of(store));
        mockMvc.perform(get("/api/v1/stores/mobilePhonesInStore/4"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].id", equalTo(1)))
            .andExpect(jsonPath("$[0].brand", equalTo("Sony")))
            .andExpect(jsonPath("$[0].model", equalTo("ExtraOne")))
            .andExpect(jsonPath("$[0].performance", equalTo(9)))
            .andExpect(jsonPath("$[0].price", equalTo(1500)))
            .andExpect(jsonPath("$[1].id", equalTo(2)))
            .andExpect(jsonPath("$[1].brand", equalTo("Sony")))
            .andExpect(jsonPath("$[1].model", equalTo("ExtraTwo")))
            .andExpect(jsonPath("$[1].performance", equalTo(8)))
            .andExpect(jsonPath("$[1].price", equalTo(1300)));
    }

    @Test
    void showAllMobilePhonesOutOfStore() throws Exception {
        Store store = new Store(4, "SonyStore", null);
        MobilePhone mp1 = new MobilePhone(
            1, "Sony", "ExtraOne", 9, 1500, null, List.of(store)
        );
        MobilePhone mp4 = new MobilePhone(
            4, "Apple", "14PRO", 10, 1900, null, null
        );
        List<MobilePhone> mobilePhonesFromStore = List.of(mp1);
        List<MobilePhone> allMobilePhones = List.of(mp1, mp4);
        store.setMobilePhones(mobilePhonesFromStore);

        Mockito.when(mobilePhoneRepository.findAll()).thenReturn(allMobilePhones);
        Mockito.when(storeRepository.findById(anyInt())).thenReturn(Optional.of(store));
        mockMvc.perform(get("/api/v1/stores/mobilePhonesOutOfStore/4"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].id", equalTo(4)))
            .andExpect(jsonPath("$[0].brand", equalTo("Apple")))
            .andExpect(jsonPath("$[0].model", equalTo("14PRO")))
            .andExpect(jsonPath("$[0].performance", equalTo(10)))
            .andExpect(jsonPath("$[0].price", equalTo(1900)));
    }
}