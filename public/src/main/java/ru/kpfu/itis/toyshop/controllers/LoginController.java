package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.toyshop.form.LoginFormBean;
import ru.kpfu.itis.toyshop.form.RegisterFormBean;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Регина on 24.03.2016.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    public static final String ATTR_LOGIN_FORM = "logForm";

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistrationPage() {
        request.setAttribute(ATTR_LOGIN_FORM, new LoginFormBean());
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_LOGIN_FORM) LoginFormBean loginFormBean,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        System.out.println(loginFormBean);
        return "catalog/catalog";
    }


}
