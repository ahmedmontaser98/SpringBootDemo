package com.example.demo.rest;

import com.example.demo.zoho.entity.Leave;
import com.example.demo.zoho.service.ZohoLeaveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Leave> getAllLeaves() {
        return zohoLeaveService.getAllLeaves();
    }

}
