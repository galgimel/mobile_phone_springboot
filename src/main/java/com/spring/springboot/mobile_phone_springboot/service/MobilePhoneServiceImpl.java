package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.dao.MobilePhoneDTO;
import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MobilePhoneServiceImpl implements MobilePhoneService {
    @Autowired
    private MobilePhoneDTO mobilePhoneDTO;

    @Override
    @Transactional
    public List<MobilePhone> getAllMobilePhones() {
        return mobilePhoneDTO.getAllMobilePhones();
    }

    @Override
    @Transactional
    public void saveMobilePhone(MobilePhone mobilePhone) {
        mobilePhoneDTO.saveMobilePhone(mobilePhone);
    }

    @Override
    @Transactional
    public MobilePhone getMobilePhone(int id) {
        return mobilePhoneDTO.getMobilePhone(id);
    }

    @Override
    @Transactional
    public void deleteMobilePhone(int id) {
        mobilePhoneDTO.deleteMobilePhone(id);
    }
}
