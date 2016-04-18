package ru.kpfu.itis.toyshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.toyshop.domain.Cart;
import ru.kpfu.itis.toyshop.domain.Order;
import ru.kpfu.itis.toyshop.domain.Order_Good;
import ru.kpfu.itis.toyshop.repository.OrderGoodRepository;

import java.util.List;

/**
 * Created by Регина on 08.04.2016.
 */
@Service
public class OrderGoodService {

    @Autowired
    private OrderGoodRepository orderGoodRepository;

    public void addGood(Cart cart, Order order) {
        Order_Good order_good = new Order_Good();
        order_good.setGoods(cart.getGoods());
        order_good.setCount(cart.getCount());
        order_good.setOrders(order);
        orderGoodRepository.saveOrderGood(order_good);
    }

    public List<Order_Good> getGoodsByOrder(Order order) {
        return orderGoodRepository.getGoodsByOrder(order);
    }
}
