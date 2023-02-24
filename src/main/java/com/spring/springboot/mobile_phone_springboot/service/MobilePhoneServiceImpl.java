package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.repository.MobilePhoneRepository;
import com.spring.springboot.mobile_phone_springboot.request.MobilePhoneRequest;
import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MobilePhoneServiceImpl implements MobilePhoneService {
    private final MobilePhoneRepository mobilePhoneRepository;

    @Autowired
    public MobilePhoneServiceImpl(final MobilePhoneRepository mobilePhoneRepository) {
        this.mobilePhoneRepository = mobilePhoneRepository;
    }

    @Override
    @Transactional
    public List<MobilePhoneResponse> getAllMobilePhones() {
        return mobilePhoneRepository.findAll().stream()
            .map(MobilePhoneResponse::of)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MobilePhoneResponse getMobilePhone(final int id) {
        return MobilePhoneResponse.of(mobilePhoneRepository.getReferenceById(id));
    }

    @Override
    @Transactional
    public MobilePhoneResponse saveMobilePhone(final MobilePhoneRequest mobilePhoneRequest) {
        MobilePhone mobilePhone = getMobilePhoneOf(mobilePhoneRequest);
        mobilePhoneRepository.save(mobilePhone);
        return MobilePhoneResponse.of(mobilePhone);
    }

    @Override
    @Transactional
    public void deleteMobilePhone(final int id) {
        mobilePhoneRepository.deleteById(id);
    }

    private MobilePhone getMobilePhoneOf(MobilePhoneRequest mobilePhoneRequest) {
        MobilePhone mobilePhone;
        Optional<MobilePhone> optional = mobilePhoneRepository.findById(mobilePhoneRequest.getId());
        mobilePhone = optional.orElseGet(MobilePhone::new);
        mobilePhone.setBrand(mobilePhoneRequest.getBrand());
        mobilePhone.setModel(mobilePhoneRequest.getModel());
        mobilePhone.setPerformance(mobilePhoneRequest.getPerformance());
        mobilePhone.setPrice(mobilePhoneRequest.getPrice());
        return mobilePhone;
    }
}