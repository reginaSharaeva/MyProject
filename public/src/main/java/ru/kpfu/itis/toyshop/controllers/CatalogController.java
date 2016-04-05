package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.toyshop.aspects.annotations.IncludeMenuList;
import ru.kpfu.itis.toyshop.domain.Good;
import ru.kpfu.itis.toyshop.service.CategoryService;
import ru.kpfu.itis.toyshop.service.GoodService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Regina on 16.03.2016.
 */
@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {

    @Autowired
    private HttpSession session;

    @Autowired
    private GoodService goodService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private HttpServletRequest request;

    private Integer LIMIT_FOR_GOOD = 10;

    /**
     * Отображение каталога с главной страницы
     *
     * @return
     */
    @IncludeMenuList
    @RequestMapping(method = RequestMethod.GET)
    public String renderCatalog(Integer limit) {
        if (limit == null) {
            limit = LIMIT_FOR_GOOD;
        }
        request.setAttribute("limit", limit);
        List<Good> goods;
        if (request.getParameter("id").equals("45")) {
            goods = goodService.getAllGoods();
            session.setAttribute("allGoods", goodService.getGoodsForPage(goods, limit));
            session.setAttribute("goodsCount", goods.size());
            session.setAttribute("allGoodsByCategory", goods);
            request.setAttribute("allCategories", categoryService.getCategoryByParent());
            request.setAttribute("id", 45L);
        } else {
            Long id = Long.parseLong(request.getParameter("id"));
            goods = goodService.getAllGoods(id);
            session.setAttribute("allGoods", goodService.getGoodsForPage(goods, limit));
            session.setAttribute("allGoodsByCategory", goods);
            request.setAttribute("allCategories", categoryService.getCategoryByParent(id));
        }
        return "catalog/catalog";
    }

    /**
     * Обработка фильтра по категории
     */
    @IncludeMenuList
    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String catalogFilter(@RequestParam(required = false) Long categoryId, Integer limit) {
        if (limit == null) {
            limit = LIMIT_FOR_GOOD;
        }
        request.setAttribute("limit", limit);

        List<Good> goods = goodService.getAllGoodsByCategory(categoryId);
        session.setAttribute("allGoods", goodService.getGoodsForPage(goods, limit));
        session.setAttribute("goodsCount", goods.size());
        session.setAttribute("allGoodsByCategory", goods);
        return "catalog/catalogContent";
    }

    @IncludeMenuList
    @RequestMapping(value = "/sorter", method = RequestMethod.POST)
    public String catalogSort(@RequestParam(required = false) String sort) {
        List<Good> allGoods = (List<Good>) session.getAttribute("allGoods");
        Object goods = goodService.getAllGoodsBySort(sort, allGoods);
        session.setAttribute("allGoods", goods);
        session.setAttribute("allGoodsByCategory", goods);
        return "catalog/catalogContent";
    }

    @IncludeMenuList
    @RequestMapping(value = "/prices", method = RequestMethod.POST)
    public String priceSort(@RequestParam(required = false) String prices, Integer limit) {
        if (limit == null) {
            limit = LIMIT_FOR_GOOD;
        }
        request.setAttribute("limit", limit);
        List<Good> allGoods = (List<Good>) session.getAttribute("allGoodsByCategory");
        List<Good> goods = goodService.getAllGoodsByPrice(prices, allGoods);
        session.setAttribute("allGoods", goodService.getGoodsForPage(goods, limit));
        session.setAttribute("goodsCount", goods.size());
        return "catalog/catalogContent";
    }
}
