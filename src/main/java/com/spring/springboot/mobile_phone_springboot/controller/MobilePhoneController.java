package com.spring.springboot.mobile_phone_springboot.controller;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.repository.UserRepository;
import com.spring.springboot.mobile_phone_springboot.response.MobilePhoneResponse;
import com.spring.springboot.mobile_phone_springboot.service.MobilePhoneService;
import com.spring.springboot.mobile_phone_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mobile_phones/")
public class MobilePhoneController {
    private final MobilePhoneService mobilePhoneService;
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public MobilePhoneController(final MobilePhoneService mobilePhoneService, UserService userService,
                                 UserRepository userRepository){
        this.mobilePhoneService = mobilePhoneService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String showAllMobilePhones(final Model model) {
        List<MobilePhoneResponse> allMobilePhones = mobilePhoneService.getAllMobilePhones();
        model.addAttribute("allMobilePhones", allMobilePhones);

        return "/mobilePhone/all-mobilePhones";
    }

    @GetMapping("{id}")
    public String getMobilePhone(@PathVariable final Integer id, final Model model) {
        if (id == 0) {
            return "redirect:/mobile_phones/";
        }
            model.addAttribute("mobilePhone", mobilePhoneService.getMobilePhone(id));
            return "/mobilePhone/mobilePhone-profile";
    }

    @GetMapping("addNewMobilePhone")
    public String addNewMobilePhone(@ModelAttribute("mobilePhone") final MobilePhone mobilePhone) {

        return "/mobilePhone/mobilePhone-create";
    }

    @PostMapping
    public String saveMobilePhone(@ModelAttribute("mobilePhone") final MobilePhone mobilePhone) {
        mobilePhoneService.saveMobilePhone(mobilePhone);

        return "redirect:/mobile_phones/";
    }

    @GetMapping("updateMobilePhone/{id}")
    public String updateMobilePhone(@PathVariable("id") final int id, final Model model) {
        model.addAttribute("mobilePhone", mobilePhoneService.getMobilePhone(id));

        return "/mobilePhone/mobilePhone-update";
    }

    @PutMapping("{id}")
    public String saveUpdatedMobilePhone(@ModelAttribute("mobilePhone") final MobilePhone mobilePhone) {
        mobilePhoneService.saveMobilePhone(mobilePhone);

        return "redirect:/mobile_phones/";
    }

    @DeleteMapping("{id}")
    public String deleteMobilePhone(@PathVariable("id") final int id) {
        mobilePhoneService.deleteMobilePhone(id);

        return "redirect:/mobile_phones/";
    }
}
