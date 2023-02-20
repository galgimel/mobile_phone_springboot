package com.spring.springboot.mobile_phone_springboot.controller;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.service.MobilePhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mobile_phones")
public class MobilePhoneController {
    private final MobilePhoneService mobilePhoneService;

    @Autowired
    public MobilePhoneController(final MobilePhoneService mobilePhoneService) {
        this.mobilePhoneService = mobilePhoneService;
    }

    @GetMapping
    public String showAllMobilePhones(final Model model) {
        model.addAttribute("allMobilePhones", mobilePhoneService.getAllMobilePhones());

        return "/mobilePhone/all-mobilePhones";
    }

    @GetMapping("/{id}")
    public String getMobilePhone(@PathVariable final Integer id, final Model model) {
        if (id == 0) {
            return "redirect:/mobile_phones";
        }
        model.addAttribute("mobilePhone", mobilePhoneService.getMobilePhone(id));

        return "/mobilePhone/mobilePhone-profile";
    }

    @GetMapping("/addNewMobilePhone")
    public String addNewMobilePhone(@ModelAttribute("mobilePhone") final MobilePhone mobilePhone) {

        return "/mobilePhone/mobilePhone-create";
    }

    @PostMapping
    public String saveNewMobilePhone(@ModelAttribute("mobilePhone") final MobilePhone mobilePhone) {
        mobilePhoneService.saveMobilePhone(mobilePhone);

        return "redirect:/mobile_phones";
    }

    @GetMapping("/updateMobilePhone/{id}")
    public String updateMobilePhone(@PathVariable("id") final int id, final Model model) {
        model.addAttribute("mobilePhone", mobilePhoneService.getMobilePhone(id));

        return "/mobilePhone/mobilePhone-update";
    }

    @PutMapping("/{id}")
    public String saveUpdatedMobilePhone(@ModelAttribute("mobilePhone") final MobilePhone mobilePhone) {
        mobilePhoneService.saveMobilePhone(mobilePhone);

        return "redirect:/mobile_phones";
    }

    @DeleteMapping("/{id}")
    public String deleteMobilePhone(@PathVariable("id") final int id) {
        mobilePhoneService.deleteMobilePhone(id);

        return "redirect:/mobile_phones";
    }
}
