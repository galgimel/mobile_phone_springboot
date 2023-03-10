package com.spring.springboot.mobile_phone_springboot.controller;

import com.spring.springboot.mobile_phone_springboot.request.MobilePhoneRequest;
import com.spring.springboot.mobile_phone_springboot.service.MobilePhoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mobile_phones")
public class MobilePhoneController {
    private final MobilePhoneService mobilePhoneService;

    public MobilePhoneController(final MobilePhoneService mobilePhoneService) {
        this.mobilePhoneService = mobilePhoneService;
    }

    @GetMapping
    public String showAllMobilePhones(final Model model) {
        model.addAttribute("allMobilePhones", mobilePhoneService.getAllMobilePhones());

        return "/mobilePhone/all-mobilePhones";
    }

    @GetMapping("/{id}")
    public String getMobilePhone(@PathVariable final int id, final Model model) {
        if (id == 0) {
            return "redirect:/mobile_phones";
        }
        model.addAttribute("mobilePhone", mobilePhoneService.getMobilePhone(id));

        return "/mobilePhone/mobilePhone-profile";
    }

    @GetMapping("/addNewMobilePhone")
    public String addNewMobilePhone(@ModelAttribute("mobilePhone") final MobilePhoneRequest request) {

        return "/mobilePhone/mobilePhone-create";
    }

    @PostMapping
    public String saveNewMobilePhone(@ModelAttribute("mobilePhone") final MobilePhoneRequest request) {
        mobilePhoneService.saveMobilePhone(request);

        return "redirect:/mobile_phones";
    }

    @GetMapping("/updateMobilePhone/{id}")
    public String updateMobilePhone(@PathVariable("id") final int id, final Model model) {
        model.addAttribute("mobilePhone", mobilePhoneService.getMobilePhone(id));

        return "/mobilePhone/mobilePhone-update";
    }

    @PutMapping("/{id}")
    public String saveUpdatedMobilePhone(@ModelAttribute("mobilePhone") final MobilePhoneRequest request) {
        mobilePhoneService.saveMobilePhone(request);

        return "redirect:/mobile_phones";
    }

    @DeleteMapping("/{id}")
    public String deleteMobilePhone(@PathVariable("id") final int id) {
        mobilePhoneService.deleteMobilePhone(id);

        return "redirect:/mobile_phones";
    }
}
