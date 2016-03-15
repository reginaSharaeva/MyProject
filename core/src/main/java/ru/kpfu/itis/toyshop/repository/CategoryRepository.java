package ru.kpfu.itis.toyshop.repository;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.toyshop.domain.Category;

import java.util.List;

/**
 * Created by Регина on 14.03.2016.
 */
@Repository
public class CategoryRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Category> getCategoryByParent(Long parent) {
        return sessionFactory.getCurrentSession().createCriteria(Category.class).add(Restrictions.eq("parent_id", parent.toString())).list();
    }

    @SuppressWarnings("unchecked")
    public List<Category> getCategoryByParent() {
        return sessionFactory.getCurrentSession().createCriteria(Category.class).add(Restrictions.in("parent_id", new String[]{"33", "34", "40"})).list();
    }


}
