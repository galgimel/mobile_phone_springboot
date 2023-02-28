package com.spring.springboot.mobile_phone_springboot.rest_controller;

import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import com.spring.springboot.mobile_phone_springboot.response.StoreResponse;
import com.spring.springboot.mobile_phone_springboot.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
@RequestMapping("/api/v1/stores")
public class StoreRestController {

    private final StoreService storeService;

    @Autowired
    public StoreRestController(StoreService storeService) {
        this.storeService = storeService;
    }

    @Operation(summary = "Get list of all stores")
    @GetMapping
    public List<StoreResponse> showAllStores() {
        return storeService.getAllStores();
    }

    @Operation(summary = "Get list of all mobile phones in store")
    @GetMapping("/mobilePhonesInStore/{storeID}")
    public List<MobilePhoneResponse> showAllMobilePhonesInStore(
        @Parameter(description = "id of store to search list of mobile phones")
        @PathVariable final int storeID
    ) {
        return storeService.getAllMobilePhonesInStore(storeID);
    }

    @Operation(summary = "Get list of all mobile phones out of store")
    @GetMapping("/mobilePhonesOutOfStore/{storeID}")
    public List<MobilePhoneResponse> showAllMobilePhonesOutOfStore(
        @Parameter(description = "id of store to search mobile phones which are not included it this store")
        @PathVariable final int storeID
    ) {
        return storeService.getAllMobilePhonesOutOfStore(storeID);
    }

    @Operation(summary = "Add mobile phone to store")
    @PostMapping("/{storeID}-{mobilePhoneID}")
    public String addMobilePhoneToStore(
        @Parameter(description = "id of store in which we want to add mobile phone")
        @PathVariable("storeID") final int storeID,
        @Parameter(description = "id of mobile phone we want to add")
        @PathVariable("mobilePhoneID") final int mobilePhoneID
    ) {
        storeService.saveMobilePhoneToStore(storeID, mobilePhoneID);

        return "Телефон с ID: " + mobilePhoneID + ", был добавлен в магазин с ID: " + storeID;
    }

    @Operation(summary = "Delete mobile phone from store")
    @DeleteMapping("/{storeID}-{mobilePhoneID}")
    public String deleteMobilePhoneFromStore(
        @Parameter(description = "id of store in which we want to delete mobile phone")
        @PathVariable("storeID") final int storeID,
        @Parameter(description = "id of mobile phone we want to delete")
        @PathVariable("mobilePhoneID") final int mobilePhoneID
    ) {
        storeService.deleteMobilePhoneFromStore(storeID, mobilePhoneID);

        return "Телефон с ID: " + mobilePhoneID + ", был удален из магазина с ID: " + storeID;
    }
}
