package com.spring.springboot.mobile_phone_springboot.response;

import com.spring.springboot.mobile_phone_springboot.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class StoreResponse {
    private final int id;
    private final String name;

    public static StoreResponse of(final Store store) {
        return StoreResponse.builder()
            .id(store.getId())
            .name(store.getName())
            .build();
    }
}