package com.spring.springboot.mobile_phone_springboot.response;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.entity.Store;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class StoreResponse {
    int id;
    String name;
    @Transient
    List<MobilePhoneResponse> mobilePhoneResponses;

    public static StoreResponse getStoreResponse(Store store) {
        return StoreResponse.builder()
            .id(store.getId())
            .name(store.getName())
            .mobilePhoneResponses(getMobilePhoneResponseInStore(store.getMobilePhones()))
            .build();
    }

    private static List<MobilePhoneResponse> getMobilePhoneResponseInStore(List<MobilePhone> mobilePhones) {
        return mobilePhones.stream()
            .map(MobilePhoneResponse::getMobilePhoneResponse)
            .collect(Collectors.toList());
    }
}