package com.klezovich.iloveme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/quotes")
@Controller
public class QuotesController {

    @GetMapping("")
    public String showQuotes() {
        return "quotes";
    }
}
