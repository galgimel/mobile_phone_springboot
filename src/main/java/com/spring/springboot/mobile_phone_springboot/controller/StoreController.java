package com.spring.springboot.mobile_phone_springboot.controller;

import com.spring.springboot.mobile_phone_springboot.response.StoreResponse;
import com.spring.springboot.mobile_phone_springboot.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("ID", storeID);

        return "/store/store-range-list.html";
    }

    @GetMapping("/addMobilePhoneToStore/{storeID}")
    public String addMobilePhoneToStore(@PathVariable("storeID") int storeID, Model model) {
        model.addAttribute("allMobilePhones",
            storeService.getAllMobilePhonesOutOfStore(storeID));
        model.addAttribute("ID", storeID);

        return "/store/store-range-update.html";
    }

    @PostMapping("/stores/{storeID}-{mobilePhoneID}")
    public String saveMobilePhoneInStore(@PathVariable("storeID") int storeID,
                                         @PathVariable("mobilePhoneID") int mobilePhoneID) {
        storeService.getAllMobilePhonesOutOfStore(storeID);
        storeService.saveMobilePhoneToStore(storeID, mobilePhoneID);

        return "redirect:/addMobilePhoneToStore/{storeID}";
    }

    @DeleteMapping("/stores/{storeID}-{mobilePhoneID}")
    public String deleteMobilePhoneFromStore(@PathVariable("storeID") int storeID,
                                             @PathVariable("mobilePhoneID") int mobilePhoneID) {
        storeService.deleteMobilePhoneFromStore(storeID, mobilePhoneID);

        return "redirect:/stores/{storeID}";
    }
}