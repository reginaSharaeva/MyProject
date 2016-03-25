package ru.kpfu.itis.toyshop.repository;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.toyshop.domain.Cart;
import ru.kpfu.itis.toyshop.domain.Good;
import ru.kpfu.itis.toyshop.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Регина on 11.03.2016.
 */
@Repository
public class CartRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private GoodRepository goodRepository;

    @Autowired
    private UserRepository userRepository;

    @SuppressWarnings("unchecked")
    public List<Cart> getAllCarts() {
        return sessionFactory.getCurrentSession().createCriteria(Cart.class).list();
    }

    @SuppressWarnings("unchecked")
    public void addInCart(Good good, User user) {
        Cart cart = (Cart) sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.conjunction().add(Restrictions.eq("users", user)).add(Restrictions.eq("goods", good))).uniqueResult();
        if (cart == null) {
            sessionFactory.getCurrentSession().save(new Cart(good, user, (long) 1));
        } else {
            Long count = cart.getCount() + 1;

            cart.setCount(count);
        }
    }
}
