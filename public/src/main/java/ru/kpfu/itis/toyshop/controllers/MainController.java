package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.toyshop.controllers.BaseController;
import ru.kpfu.itis.toyshop.service.CartService;
import ru.kpfu.itis.toyshop.service.CategoryService;
import ru.kpfu.itis.toyshop.service.GoodService;

/**
 * Created by Regina on 28.12.2015.
 */
@Controller
public class MainController extends BaseController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMainPage() {
        return "main_page";
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String renderCatalog() {
        if (request.getParameter("id") == null) {
            request.setAttribute("allGoods", goodService.getAllGoods());
            request.setAttribute("allCategories", categoryService.getCategoryByParent());
        } else {
            Long id = Long.parseLong(request.getParameter("id"));
            request.setAttribute("allGoods", goodService.getAllGoods(id));
            request.setAttribute("allCategories", categoryService.getCategoryByParent(id));
        }
        return "catalog";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String renderCart() {
        request.setAttribute("allCarts", cartService.getAllCarts());
        return "cart";
    }

    @RequestMapping(value = "/good", method = RequestMethod.GET)
    public String renderToyView() {
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

    @RequestMapping(value = "/key", method = RequestMethod.GET)
    public String renderKey() {
        return "key";
    }


}
