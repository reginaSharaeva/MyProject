package ru.kpfu.itis.toyshop.repository;

/**
 * Created by Regina on 28.12.2015.
 */
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.toyshop.domain.Good;

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
    public List<Good> getAllGoods(Long id) {
        return sessionFactory.getCurrentSession().createCriteria(Good.class).add(Restrictions.eq("category.id", id)).list();
    }

    @SuppressWarnings("unchecked")
    public Good getGoodById(Long goodId) {return (Good) sessionFactory.getCurrentSession().createCriteria(Good.class).add(Restrictions.idEq(goodId)).uniqueResult();}
}
