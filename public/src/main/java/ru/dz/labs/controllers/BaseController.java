package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Gataullin Kamil
 *         12.10.2014 22:34
 */
@Controller
public class BaseController {

    @Autowired
    protected HttpServletRequest request;

    public static String redirectToMain() {
        return "redirect:/";
    }

}
