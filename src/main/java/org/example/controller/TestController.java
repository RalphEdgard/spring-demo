package org.example.controller;

import org.example.model.UserMetadataModel;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.example.component.LoggerUtil;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;

// This is the test controller which can access parts of the app like the service layer and the components like the loggerUtil
@RestController
public class TestController {

    private final LoggerUtil loggerUtil;
    private final UserService userService;

    public TestController(LoggerUtil loggerUtil, UserService userService) {
        this.loggerUtil = loggerUtil;
        this.userService = userService;
    }

    // this is just a simple example on how we can access user data or access the dao layer
    @GetMapping("/test")
    public String test() {
        loggerUtil.log("Calling service...");
        return userService.processUser();
    }

    // this is to show that we use the controller to get access to a user service transactional method that has more than one operation
    // conceptually this does bundle up multiple operations but in actuality it only calls methods, if this had a database implemented in the backend then this would run multiple ops
    @GetMapping("/testMetadata")
    public UserMetadataModel testMetaData() {
        loggerUtil.log("Calling service...");
        return userService.getMetadataData();
    }
    @GetMapping("/testFieldInjection")
    public String testFieldInjection() {
        loggerUtil.log("Calling service for Field message...");
        return userService.executedLoggerUtilFieldInjectionServiceLayer();
    }
    @GetMapping("/getActualDataFromDb")
    public UserMetadataModel getActualDataFromDb(@RequestParam int index) {
        return userService.getActualData(index);
    }
}
