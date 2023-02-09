package com.spring.springboot.mobile_phone_springboot.controller;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import com.spring.springboot.mobile_phone_springboot.service.MobilePhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class MobilePhoneController {
    private final MobilePhoneService mobilePhoneService;

    @Autowired
    public MobilePhoneController(MobilePhoneService mobilePhoneService){
        this.mobilePhoneService = mobilePhoneService;
    }

    @GetMapping("/")
    public String backToFirstView() {
        return "first-view";
    }

    @GetMapping("/mobile_phones")
    public String showAllMobilePhones(Model model) {
        List<MobilePhoneResponse> allMobilePhones = mobilePhoneService.getAllMobilePhones();
        model.addAttribute("allMobilePhones", allMobilePhones);

        return "all-mobilePhones";
    }

    @GetMapping("/mobile_phones/{id}")
    public String getMobilePhone(@PathVariable int id, Model model) {
        if (id == 0) {
            return "redirect:/mobile_phones";
        }
            model.addAttribute("mobilePhone", mobilePhoneService.getMobilePhone(id));
            return "mobilePhone-profile";
    }

    @GetMapping("/addNewMobilePhone")
    public String addNewMobilePhone(@ModelAttribute("mobilePhone") MobilePhone mobilePhone) {

        return "mobilePhone-create";
    }

    @PostMapping("/mobile_phones")
    public String saveMobilePhone(@ModelAttribute("mobilePhone") MobilePhone mobilePhone) {
        mobilePhoneService.saveMobilePhone(mobilePhone);

        return "redirect:/mobile_phones";
    }

    @GetMapping("/updateMobilePhone/{id}")
    public String updateMobilePhone(@PathVariable("id") int id, Model model) {
        model.addAttribute("mobilePhone", mobilePhoneService.getMobilePhone(id));

        return "mobilePhone-update";
    }

    @PutMapping("/mobile_phones/{id}")
    public String saveUpdatedMobilePhone(@ModelAttribute("mobilePhone") MobilePhone mobilePhone) {
        mobilePhoneService.saveMobilePhone(mobilePhone);

        return "redirect:/mobile_phones";
    }

    @DeleteMapping("/mobile_phones/{id}")
    public String deleteMobilePhone(@PathVariable("id") int id) {
        mobilePhoneService.deleteMobilePhone(id);
        return "redirect:/mobile_phones";
    }
}
