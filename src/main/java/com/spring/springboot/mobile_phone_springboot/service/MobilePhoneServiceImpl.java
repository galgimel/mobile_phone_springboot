package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.repository.MobilePhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse.getResponse;


@Service
public class MobilePhoneServiceImpl implements MobilePhoneService {
    private MobilePhoneRepository mobilePhoneRepository;

    @Autowired
    public MobilePhoneServiceImpl(MobilePhoneRepository mobilePhoneRepository) {
        this.mobilePhoneRepository = mobilePhoneRepository;
    }

    @Override
    @Transactional
    public List<MobilePhoneResponse> getAllMobilePhones() {
        final List<MobilePhone> mobilePhoneList = mobilePhoneRepository.findAll();
        final List<MobilePhoneResponse> mobilePhoneResponseList = new ArrayList<>();
        for (MobilePhone mobilePhone : mobilePhoneList) {
            mobilePhoneResponseList.add(getResponse(mobilePhone));
        }
        return mobilePhoneResponseList;
    }

    @Override
    @Transactional
    public void saveMobilePhone(final MobilePhone mobilePhone) {
        mobilePhoneRepository.save(mobilePhone);
    }

    @Override
    @Transactional
    public MobilePhoneResponse getMobilePhone(final int id) {
        final MobilePhone mobilePhone = mobilePhoneRepository.getReferenceById(id);
        return  getResponse(mobilePhone);
    }

    @Override
    @Transactional
    public void deleteMobilePhone(final int id) {
        mobilePhoneRepository.deleteById(id);
    }


}
