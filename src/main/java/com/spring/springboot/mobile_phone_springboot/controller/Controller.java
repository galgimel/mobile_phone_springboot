package com.spring.springboot.mobile_phone_springboot.controller;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import com.spring.springboot.mobile_phone_springboot.service.MobilePhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private MobilePhoneService mobilePhoneService;
    @GetMapping
    public String backToFirstView() {
        return"first-view";
    }
    @GetMapping("/mobilePhones")

    public String showAllMobilePhones(Model model) {
        List<MobilePhone> allMobilePhones = mobilePhoneService.getAllMobilePhones();
        model.addAttribute("allMPs", allMobilePhones);

        return "all-mobilePhones";
    }

    @GetMapping("/mobilePhones/{id}")
    public MobilePhone getEmployee(@PathVariable int id) {
        MobilePhone mobilePhone = mobilePhoneService.getMobilePhone(id);

        return mobilePhone;
    }

      @PostMapping("/mobilePhones")
      public String addNewMobilePhone(Model model) {
          MobilePhone mobilePhone = new MobilePhone();
          model.addAttribute("mobilePhone", mobilePhone);

          return "mobilePhones-info";
      }

    @PutMapping("/mobilePhones")
    public String saveMobilePhone(@ModelAttribute("mobilePhone") MobilePhone mobilePhones) {
        mobilePhoneService.saveMobilePhone(mobilePhones);

        return "all-mobilePhones";
    }

//      @RequestMapping("/updateInfo")
//      public String updateMobilePhone(@RequestParam("mpId") int id, Model model) {
//          MobilePhone mobilePhone = mobilePhoneService.getMobilePhones(id);
//          model.addAttribute("mobilePhone", mobilePhone);
//
//          return "mobilePhones-info";
//      }

    @DeleteMapping("/mobilePhones/{id}")
    public String deleteMobilePhone(@RequestParam("mpId") int id) {
        mobilePhoneService.deleteMobilePhone(id);
        return "all-mobilePhones";
    }

}
