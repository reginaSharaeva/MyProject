package ru.kpfu.itis.toyshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Regina on 28.12.2015.
 */
@Controller
public class MainController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMainPage() {
        return "main_page";
    }
}
