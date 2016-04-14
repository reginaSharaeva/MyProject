package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.toyshop.aspects.annotations.IncludeMenuList;
import ru.kpfu.itis.toyshop.domain.Category;
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
    private GoodService goodService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private HttpServletRequest request;

    private Integer END_FOR_GOOD = 10;

    private Integer START_FOR_GOOD = 0;

    /**
     * Отображение каталога с главной страницы
     *
     * @return
     */
    @IncludeMenuList
    @RequestMapping(method = RequestMethod.GET)
    public String renderCatalog(@RequestParam(value="id", required = false) Long id, Integer start, Integer end) {
        if (start == null) {
            start = START_FOR_GOOD;
        }
        if (end == null) {
            end = END_FOR_GOOD;
        }
        List<Good> goods = goodService.getAllGoods(id);
        request.setAttribute("allGoods", goodService.getGoodsForPage(goods, start, end));
        request.setAttribute("goodsCount", goods.size());
        request.setAttribute("allCategories", categoryService.getCategoryByParent(id));
        request.setAttribute("categoryId", id);
        request.setAttribute("end", end);
        request.setAttribute("start", start);
        return "catalog/catalog";
    }

    @RequestMapping(value = "/showmore", method = RequestMethod.POST)
    public String addOnPage(Integer start, Integer end, Long categoryId) {
        List<Good> goods = goodService.getAllGoods(categoryId);
        request.setAttribute("allGoods", goodService.getGoodsForPage(goods, start, end));
        request.setAttribute("categoryId", categoryId);
        request.setAttribute("goodsCount", goods.size());
        request.setAttribute("end", end + 10);
        request.setAttribute("start", start + 10);
        return "catalog/catalogContent";
    }

    /**
     * Обработка фильтра по категории, сортировке, цене
     */
    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String catalogFilter(Long categoryId, Long catId, String sort, String prices, Integer start, Integer end) {
        if (start == null) {
            start = START_FOR_GOOD;
        }
        if (end == null) {
            end = END_FOR_GOOD;
        }
        List<Good> goods = goodService.getAllGoods(categoryId);
        request.setAttribute("categoryId", categoryId);
        if (catId != null) {
            goods = goodService.getAllGoodsByCategory(catId);
            request.setAttribute("categoryId", catId);
        }
        if (sort != null) {
            goods = goodService.getAllGoodsBySort(sort, goods);
        }
        if (prices != null) {
            goods = goodService.getAllGoodsByPrice(prices, goods);
        }
        request.setAttribute("start", start);
        request.setAttribute("end", end);
        request.setAttribute("allGoods", goodService.getGoodsForPage(goods, start, end));
        request.setAttribute("goodsCount", goods.size());
        return "catalog/catalogContent";
    }
}
