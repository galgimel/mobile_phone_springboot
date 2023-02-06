package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.entity.User;
import com.spring.springboot.mobile_phone_springboot.repository.UserRepository;
import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.repository.MobilePhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse.getMobilePhoneResponse;


@Service
public class MobilePhoneServiceImpl implements MobilePhoneService {
    private MobilePhoneRepository mobilePhoneRepository;
    private UserRepository userRepository;

    @Autowired
    public MobilePhoneServiceImpl(MobilePhoneRepository mobilePhoneRepository, UserRepository userRepository) {
        this.mobilePhoneRepository = mobilePhoneRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public List<MobilePhoneResponse> getAllMobilePhones() {
        final List<MobilePhone> mobilePhones = mobilePhoneRepository.findAll();
        final List<MobilePhoneResponse> mobilePhoneResponses = new ArrayList<>();
        for (MobilePhone mobilePhone : mobilePhones) {
            mobilePhoneResponses.add(getMobilePhoneResponse(mobilePhone));
        }
        return mobilePhoneResponses;
    }

    @Override
    @Transactional
    public MobilePhoneResponse getMobilePhone(final int id) {
        final MobilePhone mobilePhone = mobilePhoneRepository.getReferenceById(id);
        return getMobilePhoneResponse(mobilePhone);
    }

    @Override
    @Transactional
    public void saveMobilePhone(final MobilePhone mobilePhone) {
        mobilePhoneRepository.save(mobilePhone);
    }

    @Override
    @Transactional
    public void deleteMobilePhone(final int id) {
        for (User user :  userRepository.findUsersByMobilePhoneId(id)) {
            user.setMobilePhoneId(null);
        }
        mobilePhoneRepository.deleteById(id);
    }
}