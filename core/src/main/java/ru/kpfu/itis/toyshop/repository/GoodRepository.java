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
import java.util.ArrayList;
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
    public List<Good> getAllGoods(Long categoryId) {
        List<Category> categories = sessionFactory.getCurrentSession().createCriteria(Category.class)
                .add(Restrictions.eq("parent_id", categoryId)).list();
        return sessionFactory.getCurrentSession().createCriteria(Good.class)
                .add(Restrictions.in("category", categories.toArray())).list();
    }

    @SuppressWarnings("unchecked")
    public List<Good> getAllGoodsByCategory(Long categoryId) {
        return sessionFactory.getCurrentSession().createCriteria(Good.class)
                .add(Restrictions.eq("category.id", categoryId)).list();
    }

    @SuppressWarnings("unchecked")
    public List<Good> getAllGoodsBySort(String sort, List<Good> goods) {
        List<Long> idents = new ArrayList<>();
        for (int i = 0; i < goods.size(); i++) {
            idents.add(goods.get(i).getId());
        }
        String[] str = sort.split(",,");
        List<Good> allGoods = null;
        if (str[1].equals("desc")) {
            allGoods = sessionFactory.getCurrentSession().createCriteria(Good.class).add(Restrictions.in("id", idents)).addOrder(org.hibernate.criterion.Order.desc(str[0])).list();
        }
        if (str[1].equals("asc")) {
            allGoods = sessionFactory.getCurrentSession().createCriteria(Good.class).add(Restrictions.in("id", idents)).addOrder(org.hibernate.criterion.Order.asc(str[0])).list();
        }
        return allGoods;
    }

    @SuppressWarnings("unchecked")
    public List<Good> getAllGoodsByPrice(String prices, List<Good> goods) {
        List<Long> idents = new ArrayList<>();
        for (int i = 0; i < goods.size(); i++) {
            idents.add(goods.get(i).getId());
        }
        List<Good> allGoods = null;
        if (prices.equals("300")) {
            allGoods = sessionFactory.getCurrentSession().createCriteria(Good.class).add(Restrictions.and(Restrictions.in("id", idents)).add(Restrictions.le("price", new BigDecimal(prices)))).list();
        } else {
            if (prices.equals("1000")) {
                allGoods = sessionFactory.getCurrentSession().createCriteria(Good.class).add(Restrictions.and(Restrictions.in("id", idents)).add(Restrictions.ge("price", new BigDecimal(prices)))).list();
            } else {
                String[] pp = prices.split(",,");
                allGoods = sessionFactory.getCurrentSession().createCriteria(Good.class).add(Restrictions.and(Restrictions.in("id", idents)).add(Restrictions.ge("price", new BigDecimal(pp[0]))).add(Restrictions.le("price", new BigDecimal(pp[1])))).list();
            }
        }
        return allGoods;
    }

    @SuppressWarnings("unchecked")
    public Good getGoodById(Long goodId) {return (Good) sessionFactory.getCurrentSession().createCriteria(Good.class).add(Restrictions.idEq(goodId)).uniqueResult();}
}
