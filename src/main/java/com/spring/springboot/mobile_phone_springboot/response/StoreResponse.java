package com.spring.springboot.mobile_phone_springboot.response;

import com.spring.springboot.mobile_phone_springboot.entity.Store;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StoreResponse {
    int id;
    String name;

    public static StoreResponse getStoreResponse(Store store) {
        return StoreResponse.builder()
            .id(store.getId())
            .name(store.getName())
            .build();
    }
}