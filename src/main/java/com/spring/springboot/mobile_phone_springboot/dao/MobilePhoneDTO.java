package com.spring.springboot.mobile_phone_springboot.dao;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;

import java.util.List;

public interface MobilePhoneDTO {
    public List<MobilePhone> getAllMobilePhones();

    public void saveMobilePhone(MobilePhone mobilePhone);

    public MobilePhone getMobilePhone(int id);

    public void deleteMobilePhone(int id);

}