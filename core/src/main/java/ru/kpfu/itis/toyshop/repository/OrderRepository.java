package ru.kpfu.itis.toyshop.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.toyshop.domain.Order;

/**
 * Created by Регина on 08.04.2016.
 */
@Repository
public class OrderRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public void saveOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }
}
