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

import static com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse.getMobilePhoneResponse;
import static com.spring.springboot.mobile_phone_springboot.response.StoreResponse.getStoreResponse;

@Service
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    private final MobilePhoneRepository mobilePhoneRepository;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository,
                            MobilePhoneRepository mobilePhoneRepository) {
        this.storeRepository = storeRepository;
        this.mobilePhoneRepository = mobilePhoneRepository;
    }

    @Override
    @Transactional
    public List<StoreResponse> getAllStores() {
        return storeRepository.findAll().stream()
            .map(store -> getStoreResponse(store))
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<MobilePhoneResponse> getAllMobilePhonesInStore(final int storeID) {
        return mobilePhonesFromStore(storeID)
            .stream()
            .map(mobilePhone -> getMobilePhoneResponse(mobilePhone))
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<MobilePhoneResponse> getAllMobilePhonesOutOfStore(final int storeID) {
        return mobilePhoneRepository.findAll()
            .stream()
            .filter(mobilePhone -> !mobilePhonesFromStore(storeID).contains(mobilePhone))
            .map(mobilePhone -> getMobilePhoneResponse(mobilePhone))
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveMobilePhoneToStore(final int storeID, final MobilePhone mobilePhone) {
        mobilePhonesFromStore(storeID).add(mobilePhone);
    }

    @Override
    @Transactional
    public void deleteMobilePhoneFromStore(final int storeID, final MobilePhone mobilePhone) {
        mobilePhonesFromStore(storeID).remove(mobilePhone);
    }

    private List<MobilePhone> mobilePhonesFromStore(final int storeID) {
        return storeRepository.findById(storeID).get().getMobilePhones();
    }
}
