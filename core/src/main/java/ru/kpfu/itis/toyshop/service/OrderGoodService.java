package ru.kpfu.itis.toyshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.toyshop.domain.Order_Good;
import ru.kpfu.itis.toyshop.repository.OrderGoodRepository;

/**
 * Created by Регина on 08.04.2016.
 */
@Service
public class OrderGoodService {

    @Autowired
    private OrderGoodRepository orderGoodRepository;

    public void save(Order_Good order_good) {
        orderGoodRepository.saveOrderGood(order_good);
    }
}
