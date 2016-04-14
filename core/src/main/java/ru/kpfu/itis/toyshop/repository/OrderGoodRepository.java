package ru.kpfu.itis.toyshop.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.toyshop.domain.Order_Good;

/**
 * Created by Регина on 08.04.2016.
 */
@Repository
public class OrderGoodRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public void saveOrderGood(Order_Good order_good) {
        sessionFactory.getCurrentSession().save(order_good);
    }
}
