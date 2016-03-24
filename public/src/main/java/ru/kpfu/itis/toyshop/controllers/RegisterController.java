package ru.kpfu.itis.toyshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.toyshop.form.RegisterFormBean;

import javax.validation.Valid;

/**
 * Created by Регина on 17.03.2016.
 */
@Controller
@RequestMapping("/reg")
public class RegisterController {

    public static final String ATTR_REGISTRATION_FORM = "regForm";

    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_REGISTRATION_FORM) RegisterFormBean registerFormBean,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registerPage";
        }
        System.out.println(registerFormBean);
        return "result";
    }

}
