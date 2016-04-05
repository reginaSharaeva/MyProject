package ru.kpfu.itis.toyshop.service;

/**
 * Created by Regina on 28.12.2015.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.toyshop.domain.Category;
import ru.kpfu.itis.toyshop.domain.Good;
import ru.kpfu.itis.toyshop.repository.CategoryRepository;
import ru.kpfu.itis.toyshop.repository.GoodRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodService {

    @Autowired
    private GoodRepository goodsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    /**
     * Отображение всех товаров в каталоге
     */
    public List<Good> getAllGoods() {
        return goodsRepository.getAllGoods();
    }

    /**
     * Отображение товаров по родительским категориям
     * @param id
     * @return
     */
    public List<Good> getAllGoods(Long id) {
        List<Category> categories = categoryRepository.getCategoryByParent(id);
        return goodsRepository.getAllGoods(categories);
    }

    /**
     * Отображение товара по его id
     * @param goodId
     * @return
     */
    public Good getGood(Long goodId) {
        return goodsRepository.getGoodById(goodId);
    }

    /**
     * Отображение товаров по дочерним категориям
     * @param categoryId
     * @return
     */
    public List<Good> getAllGoodsByCategory(Long categoryId) {
        return goodsRepository.getAllGoodsByCategory(categoryId);
    }

    public List<Good> getAllGoodsBySort(String sort, List<Good> goods) {
        List<Long> idents = new ArrayList<>();
        for (int i = 0; i < goods.size(); i++) {
            idents.add(goods.get(i).getId());
        }
        String[] str = sort.split(",,");
        List<Good> allGoods = null;
        if (str[1].equals("desc")) {
            allGoods = goodsRepository.getAllGoodsByDesc(idents, str[0]);
        }
        if (str[1].equals("asc")) {
            allGoods = goodsRepository.getAllGoodsByAsc(idents, str[0]);
        }
        return allGoods;
    }

    public List<Good> getAllGoodsByPrice(String prices, List<Good> goods) {
        List<Long> idents = new ArrayList<>();
        for (int i = 0; i < goods.size(); i++) {
            idents.add(goods.get(i).getId());
        }
        List<Good> allGoods = null;
        if (prices.equals("300")) {
            allGoods = goodsRepository.getAllGoodsByPriceLess(idents, prices);
        } else {
            if (prices.equals("10000")) {
                allGoods = goodsRepository.getAllGoodsByPriceMore(idents, prices);
            } else {
                String[] pp = prices.split(",,");
                allGoods = goodsRepository.getAllGoodsByPriceBetween(idents, pp[0], pp[1]);
            }
        }
        return allGoods;
    }

    public List<Good> getGoodsForPage(List<Good> goods, int limit) {
        List<Good> result = new ArrayList<>();
        for (int i = 0; i < goods.size(); i++) {
            if (i < limit) {
                result.add(goods.get(i));
            }
        }
        return result;
    }
}
