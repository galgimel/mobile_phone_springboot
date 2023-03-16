package com.spring.springboot.mobile_phone_springboot.rest_controller_containers;

import com.spring.springboot.mobile_phone_springboot.request.UserRequest;
import com.spring.springboot.mobile_phone_springboot.rest_controller.UserRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserRestControllerTestContainers {
    @Autowired
    private UserRestController userRestController;
    @Test
    void showAllUsers() {
        Assertions.assertEquals(15, userRestController.showAllUsers().size());
    }
    @Test
    void getUser() {
        int id = 5;
        Assertions.assertEquals(5, userRestController.getUser(id).getId());
        Assertions.assertEquals("Никита", userRestController.getUser(id).getName());
        Assertions.assertEquals("Хрущев", userRestController.getUser(id).getSurname());
        Assertions.assertEquals(35, userRestController.getUser(id).getAge());
        Assertions.assertEquals(5, userRestController.getUser(id).getMobilePhoneResponse().getId());
    }

    @Test
    void addNewUser() {
        int id = 16;
        UserRequest userRequest = new UserRequest(
            id, "Томас", "Шелби", 39, 15
        );
        userRestController.addNewUser(userRequest);
        Assertions.assertEquals(id, userRestController.getUser(id).getId());
        Assertions.assertEquals("Томас", userRestController.getUser(id).getName());
        Assertions.assertEquals("Шелби", userRestController.getUser(id).getSurname());
        Assertions.assertEquals(39, userRestController.getUser(id).getAge());
        Assertions.assertEquals(15, userRestController.getUser(id).getMobilePhoneResponse().getId());
        Assertions.assertEquals(16, userRestController.showAllUsers().size());
    }

    @Test
    void updateUser() {
        int id = 16;
        UserRequest userRequest = new UserRequest(
            id, "Томас", "Шелби", 39, 15
        );
        UserRequest userRequestUpdated = new UserRequest(
            id, "Томас", "Шелби", 40, 15
        );
        userRestController.addNewUser(userRequest);

        Assertions.assertEquals(id, userRestController.getUser(id).getId());
        Assertions.assertEquals("Томас", userRestController.getUser(id).getName());
        Assertions.assertEquals("Шелби", userRestController.getUser(id).getSurname());
        Assertions.assertEquals(39, userRestController.getUser(id).getAge());
        Assertions.assertEquals(15, userRestController.getUser(id).getMobilePhoneResponse().getId());
        Assertions.assertEquals(16, userRestController.showAllUsers().size());

        userRestController.addNewUser(userRequestUpdated);

        Assertions.assertEquals(id, userRestController.getUser(id).getId());
        Assertions.assertEquals("Томас", userRestController.getUser(id).getName());
        Assertions.assertEquals("Шелби", userRestController.getUser(id).getSurname());
        Assertions.assertEquals(40, userRestController.getUser(id).getAge());
        Assertions.assertEquals(15, userRestController.getUser(id).getMobilePhoneResponse().getId());
        Assertions.assertEquals(16, userRestController.showAllUsers().size());
    }

    @Test
    void deleteUser() {
        userRestController.deleteUser(15);
        Assertions.assertEquals(14, userRestController.showAllUsers().size());
    }
}