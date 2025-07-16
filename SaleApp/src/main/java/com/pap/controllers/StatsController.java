package com.pap.controllers;

import com.pap.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatsController {
    @Autowired
    private StatsService statsService;

    @GetMapping("/stats")
    public String stats(Model model) {
        model.addAttribute("productRevenues", statsService.statsRevenueByProduct());

        return "stats";
    }
}
