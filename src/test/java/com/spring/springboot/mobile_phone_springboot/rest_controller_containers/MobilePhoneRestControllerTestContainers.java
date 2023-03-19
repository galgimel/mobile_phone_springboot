package com.spring.springboot.mobile_phone_springboot.rest_controller_containers;

import com.spring.springboot.mobile_phone_springboot.BasedTestContainersTest;
import com.spring.springboot.mobile_phone_springboot.request.MobilePhoneRequest;
import com.spring.springboot.mobile_phone_springboot.rest_controller.MobilePhoneRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

//@ActiveProfiles(profiles = {"test"})
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Testcontainers
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)

/**
 * All tests in package fot one-container-one-test
 * use '@ActiveProfiles(profiles = {"test"}' instead 'extends BasedTestContainersTest'
 * or change static methods on non-static in  'BasedTestContainersTest' with '@ActiveProfiles(profiles = {"test"}'
 */
public class MobilePhoneRestControllerTestContainers extends BasedTestContainersTest {
    @Autowired
    private MobilePhoneRestController mobilePhoneRestController;


    @Test
    void showAllMobilePhones() {
       Assertions.assertEquals(15, mobilePhoneRestController.showAllMobilePhones().size());
    }
    @Test
    void getMobilePhone() {
        int id = 5;
        Assertions.assertEquals(5, mobilePhoneRestController.getMobilePhone(id).getId());
        Assertions.assertEquals("iPhone", mobilePhoneRestController.getMobilePhone(id).getBrand());
        Assertions.assertEquals("R", mobilePhoneRestController.getMobilePhone(id).getModel());
        Assertions.assertEquals(8, mobilePhoneRestController.getMobilePhone(id).getPerformance());
        Assertions.assertEquals(1000, mobilePhoneRestController.getMobilePhone(id).getPrice());
    }

    @Test
    void addNewMobilePhone() {
        int id = 16;
        MobilePhoneRequest mobilePhoneRequest = new MobilePhoneRequest(
            id, "Nokia", "TT", 9, 99
        );
        mobilePhoneRestController.addNewMobilePhone(mobilePhoneRequest);
        Assertions.assertEquals(id, mobilePhoneRestController.getMobilePhone(id).getId());
        Assertions.assertEquals("Nokia", mobilePhoneRestController.getMobilePhone(id).getBrand());
        Assertions.assertEquals("TT", mobilePhoneRestController.getMobilePhone(id).getModel());
        Assertions.assertEquals(9, mobilePhoneRestController.getMobilePhone(id).getPerformance());
        Assertions.assertEquals(99, mobilePhoneRestController.getMobilePhone(id).getPrice());
        Assertions.assertEquals(16, mobilePhoneRestController.showAllMobilePhones().size());
    }

    @Test
    void updateMobilePhone() {
        int id = 16;
        MobilePhoneRequest mobilePhoneRequest = new MobilePhoneRequest(
            id, "Nokia", "TT", 9, 99
        );
        MobilePhoneRequest mobilePhoneRequestUpdated = new MobilePhoneRequest(
            id, "Nokia", "TT99", 9, 99
        );
        mobilePhoneRestController.addNewMobilePhone(mobilePhoneRequest);

        Assertions.assertEquals(id, mobilePhoneRestController.getMobilePhone(id).getId());
        Assertions.assertEquals("Nokia", mobilePhoneRestController.getMobilePhone(id).getBrand());
        Assertions.assertEquals("TT", mobilePhoneRestController.getMobilePhone(id).getModel());
        Assertions.assertEquals(9, mobilePhoneRestController.getMobilePhone(id).getPerformance());
        Assertions.assertEquals(99, mobilePhoneRestController.getMobilePhone(id).getPrice());
        Assertions.assertEquals(16, mobilePhoneRestController.showAllMobilePhones().size());

        mobilePhoneRestController.updateMobilePhone(mobilePhoneRequestUpdated);

        Assertions.assertEquals(id, mobilePhoneRestController.getMobilePhone(id).getId());
        Assertions.assertEquals("Nokia", mobilePhoneRestController.getMobilePhone(id).getBrand());
        Assertions.assertEquals("TT99", mobilePhoneRestController.getMobilePhone(id).getModel());
        Assertions.assertEquals(9, mobilePhoneRestController.getMobilePhone(id).getPerformance());
        Assertions.assertEquals(99, mobilePhoneRestController.getMobilePhone(id).getPrice());
        Assertions.assertEquals(16, mobilePhoneRestController.showAllMobilePhones().size());
    }

    @Test
    void deleteMobilePhone() {
        mobilePhoneRestController.deleteMobilePhone(15);
        Assertions.assertEquals(14, mobilePhoneRestController.showAllMobilePhones().size());
        Assertions.assertThrows(Exception.class, () -> {mobilePhoneRestController.getMobilePhone(15);});
    }
}