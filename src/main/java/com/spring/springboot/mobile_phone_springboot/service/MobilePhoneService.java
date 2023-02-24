package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.request.MobilePhoneRequest;
import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;

import java.util.List;

public interface MobilePhoneService {

    List<MobilePhoneResponse> getAllMobilePhones();

    MobilePhoneResponse getMobilePhone(int id);

    MobilePhoneResponse saveMobilePhone(MobilePhoneRequest mobilePhoneRequest);

    void deleteMobilePhone(int id);
}
