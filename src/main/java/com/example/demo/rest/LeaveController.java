package com.example.demo.rest;

import com.example.demo.zoho.service.ZohoLeaveService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leave")
public class LeaveController {


    private final ZohoLeaveService zohoLeaveService;

    public LeaveController(ZohoLeaveService zohoLeaveService) {
        this.zohoLeaveService = zohoLeaveService;
    }

    @PostMapping
    public String requestLeave(@RequestParam int employeeId,
                               @RequestParam int numberOfLeaveDays) {

        zohoLeaveService.requestLeave(employeeId, numberOfLeaveDays);
        return "Leave request submitted successfully!";
    }

}
