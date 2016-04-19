package ru.kpfu.itis.toyshop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.toyshop.domain.Order;
import ru.kpfu.itis.toyshop.domain.User;
import ru.kpfu.itis.toyshop.repository.OrderRepository;

import java.util.List;

/**
 * Created by Регина on 08.04.2016.
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void saveOrder(Order order) {
        orderRepository.saveOrder(order);
    }

    public List<Order> getOrderByUser(User user) {
        return orderRepository.getOrderByUser(user);
    }
}
