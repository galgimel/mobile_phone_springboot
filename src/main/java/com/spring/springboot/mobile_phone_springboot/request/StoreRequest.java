package com.spring.springboot.mobile_phone_springboot.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class StoreRequest {
    int id;
    @NotBlank
    @Size(min = 1, max = 20)
    String name;
}
