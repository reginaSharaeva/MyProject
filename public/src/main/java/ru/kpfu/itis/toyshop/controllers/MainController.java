package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.toyshop.service.CartService;
import ru.kpfu.itis.toyshop.service.CategoryService;
import ru.kpfu.itis.toyshop.service.GoodService;

import javax.servlet.http.HttpSession;

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
