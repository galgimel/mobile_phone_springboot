package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import com.spring.springboot.mobile_phone_springboot.response.StoreResponse;

import java.util.List;

public interface StoreService {
    List<StoreResponse> getAllStores();

    List<MobilePhoneResponse> getAllMobilePhonesInStore(int storeID);

    List<MobilePhoneResponse> getAllMobilePhonesOutOfStore(int storeID);

    void saveMobilePhoneToStore(int storeID, int mobilePhoneID);

    void deleteMobilePhoneFromStore(int storeID, int mobilePhoneID);
}
