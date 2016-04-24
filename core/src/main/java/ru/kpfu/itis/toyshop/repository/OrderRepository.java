package ru.kpfu.itis.toyshop.repository;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.toyshop.domain.Order;
import ru.kpfu.itis.toyshop.domain.User;

import javax.transaction.Transactional;
import java.util.List;

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

    @SuppressWarnings("unchecked")
    public List<Order> getOrderByUser(User user) {
        return sessionFactory.getCurrentSession().createCriteria(Order.class).add(Restrictions.and(Restrictions.eq("users", user)).add(Restrictions.eq("status", "Оформлен"))).list();
    }

    @Transactional
    public void updateOrder(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }

    public Order getOrderById(Long id) {
        return (Order) sessionFactory.getCurrentSession().createCriteria(Order.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

}
