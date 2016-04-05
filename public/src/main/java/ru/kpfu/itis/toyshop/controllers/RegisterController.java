package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.toyshop.aspects.annotations.IncludeMenuList;
import ru.kpfu.itis.toyshop.form.RegisterFormBean;
import ru.kpfu.itis.toyshop.sender.KeyGenerate;
import ru.kpfu.itis.toyshop.sender.Mailing;
import ru.kpfu.itis.toyshop.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Regina on 17.03.2016.
 */
@Controller
@RequestMapping("/reg")
public class RegisterController {

    @Autowired
    private UserService userService;

    public static final String ATTR_REGISTRATION_FORM = "regForm";

    @Autowired
    private HttpServletRequest request;


    @IncludeMenuList
    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistrationPage() {
        request.setAttribute(ATTR_REGISTRATION_FORM, new RegisterFormBean());
        return "register/registerPage";
    }

    @IncludeMenuList
    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_REGISTRATION_FORM) RegisterFormBean registerFormBean,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register/registerPage";
        }
        KeyGenerate keyGenerate = new KeyGenerate();
        String key = keyGenerate.generate();
        while (!userService.checkKey(key)) {
            key = keyGenerate.generate();
        }
        userService.addUser(registerFormBean.getName(), registerFormBean.getEmail(), registerFormBean.getPassword(), key);
        Mailing mailing = new Mailing();
        mailing.sendMail(registerFormBean.getEmail(), "Регистрация", "Для регистрации пройдите по ссылке http://www.localhost:8081?key=" + key);
        return "register/result";
    }
}
