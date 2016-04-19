package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.toyshop.aspects.annotations.IncludeMenuList;
import ru.kpfu.itis.toyshop.domain.User;
import ru.kpfu.itis.toyshop.form.ChangeInfoFormBean;
import ru.kpfu.itis.toyshop.service.OrderService;
import ru.kpfu.itis.toyshop.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.smartcardio.ATR;
import javax.validation.Valid;

/**
 * Regina
 * 07.04.2016 23:30
 */
@Controller
@RequestMapping("/cabinet")
public class CabinetController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    @Autowired
    private OrderService orderService;

    private final String ATTR_CHANGE_FORM = "changeForm";

    @IncludeMenuList
    @RequestMapping(method = RequestMethod.GET)
    public String renderCabinetPage() {
        User user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
        request.setAttribute("currentUser", user);
        request.setAttribute("orderGoods", orderService.getOrderByUser(user));
        return "cabinet/cabinet";
    }

    @IncludeMenuList
    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String changeInfo(@Valid @ModelAttribute(ATTR_CHANGE_FORM) ChangeInfoFormBean changeInfoFormBean,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors() || changeInfoFormBean.getPassword().equals(changeInfoFormBean.getConfirmPassword())) {
            return "cabinet/changeInfo";
        }
        return "cabinet/cabinet";
    }



}
