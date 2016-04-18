package ru.kpfu.itis.toyshop.repository;

/**
 * Created by Regina on 28.12.2015.
 */
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.toyshop.domain.User;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public User getUserById(Long userId) {return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("id", userId)).uniqueResult();}

    @SuppressWarnings("unchecked")
    public void addUser(String name, String mail, String hash_pass, String key) {
        sessionFactory.getCurrentSession().save(new User(mail, hash_pass, name, false, key, "ROLE_USER"));
    }

    @SuppressWarnings("unchecked")
    public User getUserByLogin(String login) {return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();}

    @SuppressWarnings("unchecked")
    public void setTrue(Long userId) {
        sessionFactory.getCurrentSession().createQuery("update User u set u.check = :check where u.id = :id")
                .setBoolean("check", true)
                .setLong("id", userId).executeUpdate();
    }
}

