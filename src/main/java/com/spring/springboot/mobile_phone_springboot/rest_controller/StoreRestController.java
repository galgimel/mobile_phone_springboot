package com.spring.springboot.mobile_phone_springboot.rest_controller;

import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import com.spring.springboot.mobile_phone_springboot.response.StoreResponse;
import com.spring.springboot.mobile_phone_springboot.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreRestController {

    private final StoreService storeService;

    @Autowired
    public StoreRestController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<StoreResponse> showAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping("/mobilePhonesInStore/{storeID}")
    public List<MobilePhoneResponse> showAllMobilePhonesInStore(@PathVariable final int storeID) {
        return storeService.getAllMobilePhonesInStore(storeID);
    }

    @GetMapping("/mobilePhonesOutOfStore/{storeID}")
    public List<MobilePhoneResponse> showAllMobilePhonesOutOfStore(@PathVariable final int storeID) {
        return storeService.getAllMobilePhonesOutOfStore(storeID);
    }

    @PostMapping("/{storeID}-{mobilePhoneID}")
    public String addMobilePhoneToStore(
        @PathVariable("storeID") final int storeID,
        @PathVariable("mobilePhoneID") final int mobilePhoneID
    ) {
        storeService.saveMobilePhoneToStore(storeID, mobilePhoneID);

        return "Телефон с ID: " + mobilePhoneID + ", был добавлен из магазина с ID: " + storeID;
    }

    @DeleteMapping("/{storeID}-{mobilePhoneID}")
    public String deleteMobilePhoneFromStore(
        @PathVariable("storeID") final int storeID,
        @PathVariable("mobilePhoneID") final int mobilePhoneID
    ) {
        storeService.deleteMobilePhoneFromStore(storeID, mobilePhoneID);

        return "Телефон с ID: " + mobilePhoneID + ", был удален из магазина с ID: " + storeID;
    }
}
