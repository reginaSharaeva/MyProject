package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.toyshop.aspects.annotations.IncludeMenuList;
import ru.kpfu.itis.toyshop.domain.User;
import ru.kpfu.itis.toyshop.form.RegistrationFormBean;
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
public class RegistrationController {

    @Autowired
    private UserService userService;

    public static final String ATTR_REGISTRATION_FORM = "regForm";

    @Autowired
    private HttpServletRequest request;


    @IncludeMenuList
    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistrationPage() {
        request.setAttribute(ATTR_REGISTRATION_FORM, new RegistrationFormBean());
        return "registration/registrationPage";
    }

    @IncludeMenuList
    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_REGISTRATION_FORM) RegistrationFormBean registrationFormBean,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors() || !userService.checkUser(registrationFormBean.getEmail()) ||
                !registrationFormBean.getPassword().equals(registrationFormBean.getConfirmPassword())) {
            request.setAttribute("contains", true);
            return "registration/registrationPage";
        }
        KeyGenerate keyGenerate = new KeyGenerate();
        String key = keyGenerate.generate();
        userService.addUser(registrationFormBean.getName(), registrationFormBean.getEmail(), registrationFormBean.getPassword(), key);
        Mailing mailing = new Mailing();
        User user = userService.getUserByLogin(registrationFormBean.getEmail());
        mailing.sendMail(registrationFormBean.getEmail(), "Registration", "Ваша регистрация прошла успешно! \nПройдите по ссылке: http://www.localhost:8088/?id=" + user.getId() + "&key=" + key);
        request.setAttribute("contains", null);
        return "registration/result";
    }
}
