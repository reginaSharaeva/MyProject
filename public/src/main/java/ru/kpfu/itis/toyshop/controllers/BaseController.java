package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;


@Controller
public class BaseController {

    @Autowired
    protected HttpServletRequest request;

    public static String redirectToMain() {
        return "redirect:/";
    }

}
