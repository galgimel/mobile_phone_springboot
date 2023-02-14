package com.spring.springboot.mobile_phone_springboot.controller;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.response.StoreResponse;
import com.spring.springboot.mobile_phone_springboot.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StoreController {
    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/stores")
    public String showAllStores(Model model) {
        List<StoreResponse> allStores = storeService.getAllStores();
        model.addAttribute("allStores", allStores);

        return "/store/all-stores.html";
    }

    @GetMapping("/stores/{storeID}")
    public String showAllMobilePhonesInStore(@PathVariable int storeID, Model model) {
        model.addAttribute("allMobilePhones",
            storeService.getAllMobilePhonesInStore(storeID));
        return "/store/store-range-list.html";
    }

    @GetMapping("/addMobilePhoneToStore/{storeID}")
    public String addMobilePhoneToStore(@PathVariable("storeID") int storeID, Model model) {
        model.addAttribute("allMobilePhones",
            storeService.getAllMobilePhonesOutOfStore(storeID));
        return "/store/store-range-update.html";
    }

    @PutMapping("/stores/{storeID}")
    public String saveMobilePhoneInStore(@PathVariable("storeID") int storeID,
                                         @ModelAttribute("mobilePhone") MobilePhone mobilePhone) {
        storeService.saveMobilePhoneToStore(storeID, mobilePhone);
        return "redirect:/stores/{storeID}";
    }

    @DeleteMapping("/stores/{storeID}")
    public String deleteMobilePhoneFromStore(@PathVariable("storeID") int storeID,
                                             @ModelAttribute("mobilePhone") MobilePhone mobilePhone) {
        storeService.deleteMobilePhoneFromStore(storeID, mobilePhone);
        return "redirect:/stores/{storeID}";
    }
}