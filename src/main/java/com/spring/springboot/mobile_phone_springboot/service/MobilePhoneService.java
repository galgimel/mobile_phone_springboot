package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;

import java.util.List;

public interface MobilePhoneService {
    public List<MobilePhoneResponse> getAllMobilePhones();
    public void saveMobilePhone(MobilePhone mobilePhone);
    public MobilePhoneResponse getMobilePhone(int id);
    public void deleteMobilePhone(int id);
}
