package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.toyshop.domain.Good;
import ru.kpfu.itis.toyshop.service.CategoryService;
import ru.kpfu.itis.toyshop.service.GoodService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Регина on 16.03.2016.
 */
@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private GoodService goodService;

    /**
     * Обработка фильтра по категории
     */
    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String catalogFilter(@RequestParam(required = false) Long categoryId) {
        List<Good> goods = goodService.getAllGoodsByCategory(categoryId);
        request.setAttribute("allGoods", goods);
        return "catalogContent";
    }


}
