package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;

import java.util.List;

public interface MobilePhoneService {
    List<MobilePhoneResponse> getAllMobilePhones();
    void saveMobilePhone(MobilePhone mobilePhone);
    MobilePhoneResponse getMobilePhone(int id);
    void deleteMobilePhone(int id);
}
