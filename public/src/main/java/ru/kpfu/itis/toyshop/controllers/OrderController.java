package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * Created by Регина on 03.04.2016.
 */
@Controller
public class OrderController {

    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String renderToyView(BigDecimal totalAmount) {
        request.setAttribute("totalAmount", totalAmount);
        return "orderPage";
    }
}
