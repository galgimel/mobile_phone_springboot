package com.spring.springboot.mobile_phone_springboot.controller;

import com.spring.springboot.mobile_phone_springboot.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/stores")
public class StoreController {
    private final StoreService storeService;

    public StoreController(final StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public String showAllStores(final Model model) {
        model.addAttribute("allStores", storeService.getAllStores());

        return "/store/all-stores";
    }

    @GetMapping("/{storeID}")
    public String showAllMobilePhonesInStore(@PathVariable final int storeID, final Model model) {
        model.addAttribute("allMobilePhones", storeService.getAllMobilePhonesInStore(storeID));
        model.addAttribute("ID", storeID);

        return "/store/store-range-list";
    }

    @GetMapping("/addMobilePhoneToStore/{storeID}")
    public String addMobilePhoneToStore(@PathVariable("storeID") final int storeID, final Model model) {
        model.addAttribute("allMobilePhones", storeService.getAllMobilePhonesOutOfStore(storeID));
        model.addAttribute("ID", storeID);

        return "/store/store-range-update";
    }

    @PostMapping("/{storeID}-{mobilePhoneID}")
    public String saveMobilePhoneInStore(
        @PathVariable("storeID") final int storeID,
        @PathVariable("mobilePhoneID") final int mobilePhoneID
    ) {
        storeService.getAllMobilePhonesOutOfStore(storeID);
        storeService.saveMobilePhoneToStore(storeID, mobilePhoneID);

        return "redirect:/addMobilePhoneToStore/{storeID}";
    }

    @DeleteMapping("/{storeID}-{mobilePhoneID}")
    public String deleteMobilePhoneFromStore(
        @PathVariable("storeID") final int storeID,
        @PathVariable("mobilePhoneID") final int mobilePhoneID
    ) {
        storeService.deleteMobilePhoneFromStore(storeID, mobilePhoneID);

        return "redirect:/stores/{storeID}";
    }
}