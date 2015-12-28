package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.toyshop.controllers.BaseController;
import ru.kpfu.itis.toyshop.service.GoodService;

/**
 * Created by Regina on 28.12.2015.
 */
@Controller
public class MainController extends BaseController {

    @Autowired
    private GoodService goodService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMainPage() {
        return "main_page";
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String renderCatalog() {
        request.setAttribute("allGoods", goodService.getAllGoods());
        return "catalog";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String renderCart() {
        return "cart";
    }

    @RequestMapping(value = "/good", method = RequestMethod.GET)
    public String renderBookView() {
        return "good";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String renderLogin() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String renderRegister() {
        return "register";
    }


}
