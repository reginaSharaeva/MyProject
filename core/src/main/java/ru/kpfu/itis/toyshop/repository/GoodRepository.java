package ru.kpfu.itis.toyshop.repository;

/**
 * Created by Regina on 28.12.2015.
 */
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.toyshop.domain.Category;
import ru.kpfu.itis.toyshop.domain.Good;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class GoodRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Good> getAllGoods() {
        return sessionFactory.getCurrentSession().createCriteria(Good.class).list();
    }

    @SuppressWarnings("unchecked")
    public List<Good> getAllGoods(List<Category> categories) {
        return sessionFactory.getCurrentSession().createCriteria(Good.class)
                .add(Restrictions.in("category", categories)).list();
    }

    @SuppressWarnings("unchecked")
    public List<Good> getAllGoodsByCategory(Long categoryId) {
        return sessionFactory.getCurrentSession().createCriteria(Good.class)
                .add(Restrictions.eq("category.id", categoryId)).list();
    }

    @SuppressWarnings("unchecked")
    public List<Good> getAllGoodsByAsc(List<Long> idents, String str) {
        return sessionFactory.getCurrentSession().createCriteria(Good.class).add(Restrictions.in("id", idents)).addOrder(org.hibernate.criterion.Order.asc(str)).list();
    }

    @SuppressWarnings("unchecked")
    public List<Good> getAllGoodsByDesc(List<Long> idents, String str) {
        return sessionFactory.getCurrentSession().createCriteria(Good.class).add(Restrictions.in("id", idents)).addOrder(org.hibernate.criterion.Order.desc(str)).list();
    }

    @SuppressWarnings("unchecked")
    public List<Good> getAllGoodsByPriceLess(List<Long> idents, String prices) {
        return sessionFactory.getCurrentSession().createCriteria(Good.class).add(Restrictions.and(Restrictions.in("id", idents)).add(Restrictions.le("price", new BigDecimal(prices)))).list();
    }

    @SuppressWarnings("unchecked")
    public List<Good> getAllGoodsByPriceMore(List<Long> idents, String prices) {
        return sessionFactory.getCurrentSession().createCriteria(Good.class).add(Restrictions.and(Restrictions.in("id", idents)).add(Restrictions.ge("price", new BigDecimal(prices)))).list();
    }

    @SuppressWarnings("unchecked")
    public List<Good> getAllGoodsByPriceBetween(List<Long> idents, String price1, String price2) {
        return sessionFactory.getCurrentSession().createCriteria(Good.class).add(Restrictions.and(Restrictions.in("id", idents)).add(Restrictions.ge("price", new BigDecimal(price1))).add(Restrictions.le("price", new BigDecimal(price2)))).list();
    }

    @SuppressWarnings("unchecked")
    public Good getGoodById(Long goodId) {return (Good) sessionFactory.getCurrentSession().createCriteria(Good.class).add(Restrictions.idEq(goodId)).uniqueResult();}
}
