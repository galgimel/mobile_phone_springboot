package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.repository.MobilePhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MobilePhoneServiceImpl implements MobilePhoneService {
    @Autowired
    private MobilePhoneRepository mobilePhoneRepository;

    @Override
    @Transactional
    public List<MobilePhoneResponse> getAllMobilePhones() {
        List<MobilePhone> mobilePhoneList = mobilePhoneRepository.findAll();
        List<MobilePhoneResponse> mobilePhoneResponseList = new ArrayList<>();
        for (MobilePhone mobilePhone : mobilePhoneList) {
            mobilePhoneResponseList.add( MobilePhoneResponse.builder()
                .id(mobilePhone.getId())
                .brand(mobilePhone.getBrand())
                .model(mobilePhone.getModel())
                .performance(mobilePhone.getPerformance())
                .price(mobilePhone.getPrice())
                .build());
        }
        return mobilePhoneResponseList;
    }

    @Override
    @Transactional
    public void saveMobilePhone(MobilePhone mobilePhone) {
        mobilePhoneRepository.save(mobilePhone);
    }

    @Override
    @Transactional
    public MobilePhoneResponse getMobilePhone(int id) {
        MobilePhone mobilePhone = mobilePhoneRepository.findById(id);
        return MobilePhoneResponse.builder()
            .id(mobilePhone.getId())
            .brand(mobilePhone.getBrand())
            .model(mobilePhone.getModel())
            .performance(mobilePhone.getPerformance())
            .price(mobilePhone.getPrice())
            .build();
    }

    @Override
    @Transactional
    public void deleteMobilePhone(int id) {
        mobilePhoneRepository.deleteById(id);
    }
}
