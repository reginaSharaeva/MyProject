package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.toyshop.form.RegisterFormBean;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Regina on 17.03.2016.
 */
@Controller
@RequestMapping("/reg")
public class RegisterController {

    public static final String ATTR_REGISTRATION_FORM = "regForm";

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistrationPage() {
        request.setAttribute(ATTR_REGISTRATION_FORM, new RegisterFormBean());
        return "register/registerPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_REGISTRATION_FORM) RegisterFormBean registerFormBean,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register/registerPage";
        }
        System.out.println(registerFormBean);
        return "register/result";
    }
}
