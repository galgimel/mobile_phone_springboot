package com.spring.springboot.mobile_phone_springboot.controller;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.service.MobilePhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
    @Autowired
    private MobilePhoneService mobilePhoneService;


    @GetMapping("/")
    public String backToFirstView() {
        return "first-view";
    }


    @GetMapping("/showMobilePhones")

    public String showAllMobilePhones(Model model) {
        List<MobilePhone> allMobilePhones = mobilePhoneService.getAllMobilePhones();
        model.addAttribute("allMobilePhones", allMobilePhones);

        return "all-mobilePhones";
    }


    @GetMapping("/getMobilePhones/{id}")
    public String getMobilePhone(@PathVariable int id, Model model) {
        model.addAttribute("mobilePhone", mobilePhoneService.getMobilePhone(id));

        return "mobilePhone-profile";
    }


    @GetMapping("/addNewMobilePhone")
    public String addNewMobilePhone(@ModelAttribute("mobilePhone") MobilePhone mobilePhone) {

        return "mobilePhone-create";
    }
    @PostMapping("/saveMobilePhone")
    public String saveMobilePhone(@ModelAttribute("mobilePhone") MobilePhone mobilePhone) {
        mobilePhoneService.saveMobilePhone(mobilePhone);

        return "redirect:/showMobilePhones";
    }

    @GetMapping("/updateMobilePhone/{id}")
    public String updateMobilePhone(@PathVariable("id") int id, Model model) {
        model.addAttribute("mobilePhone", mobilePhoneService.getMobilePhone(id));

        return "mobilePhone-update";
    }

    @PatchMapping("/saveUpdatedMobilePhone")
    public String saveUpdatedMobilePhone(@ModelAttribute("mobilePhone") MobilePhone mobilePhone) {
        mobilePhoneService.saveMobilePhone(mobilePhone);

        return "redirect:/showMobilePhones";
    }

    @RequestMapping("/deleteEmployee/{id}")
    public String deleteMobilePhone(@PathVariable("id") int id) {
        mobilePhoneService.deleteMobilePhone(id);
        return "redirect:/showMobilePhones";
    }
}
