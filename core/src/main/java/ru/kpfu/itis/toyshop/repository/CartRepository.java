package ru.kpfu.itis.toyshop.repository;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.toyshop.domain.Cart;
import ru.kpfu.itis.toyshop.domain.Good;
import ru.kpfu.itis.toyshop.domain.User;
import java.util.List;

/**
 * Created by
 * Regina
 * on 11.03.2016.
 */
@Repository
public class CartRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Cart> getAllCarts() {
        return sessionFactory.getCurrentSession().createCriteria(Cart.class).list();
    }

    @SuppressWarnings("unchecked")
    public Cart getCartByUserAndGood(Good good, User user) {
        return (Cart) sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.conjunction().add(Restrictions.eq("users", user)).add(Restrictions.eq("goods", good))).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public Cart getCartById(Long cartId) {
        return (Cart) sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("id", cartId)).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public void saveCart(Good good, User user) {
        sessionFactory.getCurrentSession().save(new Cart(good, user, (long) 1));
    }

    @SuppressWarnings("unchecked")
    public void updateCount(Cart cart) {
        sessionFactory.getCurrentSession().createQuery("update Cart c set c.count = :count where c.id = :id")
                .setLong("count", cart.getCount() + 1)
                .setLong("id", cart.getId()).executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public void doCountLess(Cart cart) {
        sessionFactory.getCurrentSession().createQuery("update Cart c set c.count = :count where c.id = :id")
                .setLong("count", cart.getCount() - 1)
                .setLong("id", cart.getId()).executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public void cartRemove(Long cartId) {
        sessionFactory.getCurrentSession().createQuery("delete from Cart c where c.id = :id")
                .setLong("id", cartId).executeUpdate();
    }
}
