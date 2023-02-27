package com.spring.springboot.mobile_phone_springboot.request;

import lombok.*;
import org.springframework.lang.NonNull;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class StoreRequest {
    int id;
    @NonNull
    String name;
}
