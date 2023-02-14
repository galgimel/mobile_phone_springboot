package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import com.spring.springboot.mobile_phone_springboot.response.StoreResponse;

import java.util.List;

public interface StoreService {
    List<StoreResponse> getAllStores();

    List<MobilePhoneResponse> getAllMobilePhonesInStore(final int storeID);
    List<MobilePhoneResponse> getAllMobilePhonesOutOfStore(final int storeID);

    void saveMobilePhoneToStore(final int storeID, final MobilePhone mobilePhone);

    void deleteMobilePhoneFromStore(final int storeID, final MobilePhone mobilePhone);
}
