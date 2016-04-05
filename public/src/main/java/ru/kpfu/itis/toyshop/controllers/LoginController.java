package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.toyshop.aspects.annotations.IncludeMenuList;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Regina on 24.03.2016.
 */
@Controller
public class LoginController {

    @Autowired
    private HttpServletRequest request;

    @IncludeMenuList
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String renderLoginPage(Boolean error) {
        request.setAttribute("error", error);
        return "login";
    }
}
