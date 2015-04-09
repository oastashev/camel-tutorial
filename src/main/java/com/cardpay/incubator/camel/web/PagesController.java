package com.cardpay.incubator.camel.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

    @RequestMapping(value = "/")
    String mainPage(Model model) {
        return "main";
    }

}
