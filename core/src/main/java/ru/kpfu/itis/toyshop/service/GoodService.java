package ru.kpfu.itis.toyshop.service;

/**
 * Created by Regina on 28.12.2015.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.toyshop.domain.Good;
import ru.kpfu.itis.toyshop.repository.GoodRepository;

import java.util.List;

@Service
public class GoodService {

    @Autowired
    private GoodRepository goodsRepository;

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
        return goodsRepository.getAllGoods(id);
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
}
