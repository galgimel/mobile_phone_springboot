package com.spring.springboot.mobile_phone_springboot.rest_controller;

import com.spring.springboot.mobile_phone_springboot.request.MobilePhoneRequest;
import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import com.spring.springboot.mobile_phone_springboot.service.MobilePhoneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    @Operation(summary = "Get list of all mobile phones")
    @GetMapping
    public List<MobilePhoneResponse> showAllMobilePhones() {
        return mobilePhoneService.getAllMobilePhones();
    }

    @Operation(summary = "Get a mobile phone by it's id")
    @GetMapping("/{id}")
    public MobilePhoneResponse getMobilePhone(
        @Parameter(description = "id of mobile phone to search")
        @PathVariable final int id
    ) {
        return mobilePhoneService.getMobilePhone(id);
    }

    @Operation(summary = "Add new mobile phone")
    @PostMapping
    public MobilePhoneResponse addNewMobilePhone(@RequestBody final MobilePhoneRequest mobilePhoneRequest) {
         return mobilePhoneService.saveMobilePhone(mobilePhoneRequest);
    }

    @Operation(summary = "Update mobile phone")
    @PutMapping
    public MobilePhoneResponse updateMobilePhone(@RequestBody final MobilePhoneRequest mobilePhoneRequest) {
        return mobilePhoneService.saveMobilePhone(mobilePhoneRequest);
    }

    @Operation(summary = "Delete mobile phone by it's id")
    @DeleteMapping("/{id}")
    public String deleteMobilePhone(
        @Parameter(description = "id of mobile phone to delete")
        @PathVariable final int id
    ) {
        mobilePhoneService.deleteMobilePhone(id);
        return "Телефон с ID: " + id + ", был удален";
    }
}
