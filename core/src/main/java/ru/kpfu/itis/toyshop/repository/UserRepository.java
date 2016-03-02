package ru.kpfu.itis.toyshop.repository;

/**
 * Created by Regina on 28.12.2015.
 */
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.toyshop.domain.Good;
import ru.kpfu.itis.toyshop.domain.User;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }
}
