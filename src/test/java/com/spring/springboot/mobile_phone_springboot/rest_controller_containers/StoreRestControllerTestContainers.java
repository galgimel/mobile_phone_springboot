package com.spring.springboot.mobile_phone_springboot.rest_controller_containers;

import com.spring.springboot.mobile_phone_springboot.BasedTestContainersTest;
import com.spring.springboot.mobile_phone_springboot.rest_controller.StoreRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

//@ActiveProfiles(profiles = {"test"})
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Testcontainers
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class StoreRestControllerTestContainers extends BasedTestContainersTest {
    @Autowired
    private StoreRestController storeRestController;
    @Test
    void showAllStores() {
        Assertions.assertEquals(3, storeRestController.showAllStores().size());
    }

    @Test
    void showAllMobilePhonesInStore() {
        Assertions.assertEquals(5, storeRestController.showAllMobilePhonesInStore(1).size());
        Assertions.assertEquals(5, storeRestController.showAllMobilePhonesInStore(2).size());
        Assertions.assertEquals(10, storeRestController.showAllMobilePhonesInStore(3).size());
    }
    @Test
    void showAllMobilePhonesOutOfStore() {
        Assertions.assertEquals(10, storeRestController.showAllMobilePhonesOutOfStore(1).size());
        Assertions.assertEquals(10, storeRestController.showAllMobilePhonesOutOfStore(2).size());
        Assertions.assertEquals(5, storeRestController.showAllMobilePhonesOutOfStore(3).size());
    }

    @Test
    void addMobilePhoneToStore() {
        storeRestController.addMobilePhoneToStore(3, 3);
        Assertions.assertEquals(11, storeRestController.showAllMobilePhonesInStore(3).size());
        Assertions.assertEquals(4, storeRestController.showAllMobilePhonesOutOfStore(3).size());
    }

    @Test
    void deleteMobilePhoneFromStore() {
        storeRestController.deleteMobilePhoneFromStore(3, 15);
        Assertions.assertEquals(9, storeRestController.showAllMobilePhonesInStore(3).size());
        Assertions.assertEquals(6, storeRestController.showAllMobilePhonesOutOfStore(3).size());
    }
}