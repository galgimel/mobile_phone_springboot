package com.spring.springboot.mobile_phone_springboot.service;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.repository.MobilePhoneRepository;
import com.spring.springboot.mobile_phone_springboot.repository.StoreRepository;
import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import com.spring.springboot.mobile_phone_springboot.response.StoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    private final MobilePhoneRepository mobilePhoneRepository;

    @Autowired
    public StoreServiceImpl(final StoreRepository storeRepository,
                            final MobilePhoneRepository mobilePhoneRepository) {
        this.storeRepository = storeRepository;
        this.mobilePhoneRepository = mobilePhoneRepository;
    }

    @Override
    @Transactional
    public List<StoreResponse> getAllStores() {
        return storeRepository.findAll().stream()
            .map(StoreResponse::getStoreResponse)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<MobilePhoneResponse> getAllMobilePhonesInStore(final int storeID) {
        return mobilePhonesFromStore(storeID)
            .stream()
            .map(MobilePhoneResponse::getMobilePhoneResponse)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<MobilePhoneResponse> getAllMobilePhonesOutOfStore(final int storeID) {
        return mobilePhoneRepository.findAll()
            .stream()
            .filter(mobilePhone -> !mobilePhonesFromStore(storeID).contains(mobilePhone))
            .map(MobilePhoneResponse::getMobilePhoneResponse)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveMobilePhoneToStore(final int storeID, final int mobilePhoneID) {
        mobilePhonesFromStore(storeID).add(mobilePhoneRepository.getReferenceById(mobilePhoneID));
    }

    @Override
    @Transactional
    public void deleteMobilePhoneFromStore(final int storeID, final int mobilePhoneID) {
        mobilePhonesFromStore(storeID).remove(mobilePhoneRepository.getReferenceById(mobilePhoneID));
    }

    private List<MobilePhone> mobilePhonesFromStore(final int storeID) {
        return storeRepository.findById(storeID).orElseThrow().getMobilePhones();
    }
}