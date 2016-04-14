package ru.kpfu.itis.toyshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Regina
 * 07.04.2016 23:30
 */
@Controller
@RequestMapping("/cabinet")
public class CabinetController {

    @RequestMapping(method = RequestMethod.GET)
    public String renderCabinetPage() {
        return "/cabinet";
    }
}
