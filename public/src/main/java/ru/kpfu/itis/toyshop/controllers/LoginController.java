package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.toyshop.aspects.annotations.IncludeMenuList;
import ru.kpfu.itis.toyshop.domain.Cart;
import ru.kpfu.itis.toyshop.domain.User;
import ru.kpfu.itis.toyshop.security.MyUserDetail;
import ru.kpfu.itis.toyshop.security.MyUserDetailService;
import ru.kpfu.itis.toyshop.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;


/**
 * Created by Regina on 24.03.2016.
 */
@Controller
public class LoginController {

    @Autowired
    private HttpServletRequest request;

    @IncludeMenuList
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String renderLoginPage(Boolean error, @RequestParam(value = "totalAmount", required = false) BigDecimal totalAmount) {
        request.setAttribute("error", error);
        if (totalAmount != null) {
            request.setAttribute("orders", true);
        }
        return "login";
    }
}
