package com.finance.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finance.dashboard.service.FinancialRecordService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private FinancialRecordService service;

    @GetMapping("/total-income")
    public Double getTotalIncome() {
        return service.getTotalIncome();
    }

    @GetMapping("/total-expense")
    public Double getTotalExpense() {
        return service.getTotalExpense();
    }

    @GetMapping("/net-balance")
    public Double getNetBalance() {
        return service.getNetBalance();
    }
}