package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.toyshop.aspects.annotations.IncludeMenuList;
import ru.kpfu.itis.toyshop.domain.User;
import ru.kpfu.itis.toyshop.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Regina on 28.12.2015.
 */
@Controller
public class MainController extends BaseController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @IncludeMenuList
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMainPage(@RequestParam(value = "id", required = false) Long id,
                                 @RequestParam(value = "key", required = false) String key) {
        if (key != null && id != null) {
            User user = userService.getUserById(id);
            if (user.getKey().equals(key)) {
                userService.changeCheck(user.getId());
            } else {
                return "error_page";
            }
        }
        return "main_page";
    }
}
