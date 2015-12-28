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
    public List<Good> getAllGoods() {
        return goodsRepository.getAllGoods();
    }
}
