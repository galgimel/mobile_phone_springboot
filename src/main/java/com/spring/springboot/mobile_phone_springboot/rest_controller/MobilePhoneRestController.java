package com.spring.springboot.mobile_phone_springboot.rest_controller;

import com.spring.springboot.mobile_phone_springboot.request.MobilePhoneRequest;
import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import com.spring.springboot.mobile_phone_springboot.service.MobilePhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mobile_phones")
public class MobilePhoneRestController {

    private final MobilePhoneService mobilePhoneService;

    @Autowired
    public MobilePhoneRestController(MobilePhoneService mobilePhoneService) {
        this.mobilePhoneService = mobilePhoneService;
    }

    @GetMapping
    public List<MobilePhoneResponse> showAllMobilePhones() {
        return mobilePhoneService.getAllMobilePhones();
    }

    @GetMapping("/{id}")
    public MobilePhoneResponse getMobilePhone(@PathVariable final int id) {
        return mobilePhoneService.getMobilePhone(id);
    }

    @PostMapping
    public MobilePhoneResponse addNewMobilePhone(@RequestBody final MobilePhoneRequest mobilePhoneRequest) {
         return mobilePhoneService.saveMobilePhone(mobilePhoneRequest);
    }

    @PutMapping
    public MobilePhoneResponse updateMobilePhone(@RequestBody final MobilePhoneRequest mobilePhoneRequest) {
        return mobilePhoneService.saveMobilePhone(mobilePhoneRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteMobilePhone(@PathVariable final int id) {
        mobilePhoneService.deleteMobilePhone(id);
        return "Телефон с ID: " + id + ", был удален";
    }
}
