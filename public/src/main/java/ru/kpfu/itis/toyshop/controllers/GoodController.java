package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.toyshop.aspects.annotations.IncludeMenuList;
import ru.kpfu.itis.toyshop.service.GoodService;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Regina on 10.03.2016.
 */
@Controller
@RequestMapping(value = "/good")
public class GoodController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private GoodService goodService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderToyView() {
        return "good";
    }
    /**
     *
     * Отображение товара
     */
    @IncludeMenuList
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderGoodPage(@PathVariable("id") Long goodId) {
        request.setAttribute("good", goodService.getGood(goodId));
        return "/good";
    }
}
