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
    public Cart getCartByUserAndGood(Good good, User user) {
        return (Cart) sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.conjunction().add(Restrictions.eq("users", user)).add(Restrictions.eq("goods", good))).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Cart> getCartByUser(User user) {
        return sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("users", user)).list();
    }

    @SuppressWarnings("unchecked")
    public void saveCart(Good good, User user) {
        sessionFactory.getCurrentSession().save(new Cart(good, user, (long) 1));
    }

    @SuppressWarnings("unchecked")
    public void updateCount(Cart cart) {
        sessionFactory.getCurrentSession().createQuery("update Cart c set c.count = :count where c.goods.id = :id")
                .setLong("count", cart.getCount() + 1)
                .setLong("id", cart.getGoods().getId()).executeUpdate();
    }


    @SuppressWarnings("unchecked")
    public void doCountLess(Cart cart) {
        sessionFactory.getCurrentSession().createQuery("update Cart c set c.count = :count where c.goods.id = :id")
                .setLong("count", cart.getCount() - 1)
                .setLong("id", cart.getGoods().getId()).executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public void cartRemove(Cart cart) {
        sessionFactory.getCurrentSession().createQuery("delete from Cart c where c.goods.id = :id")
                .setLong("id", cart.getGoods().getId()).executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public void deleteCart(Long id) {
        sessionFactory.getCurrentSession().createQuery("delete from Cart c where c.id = :id")
                .setLong("id", id).executeUpdate();
    }
}
