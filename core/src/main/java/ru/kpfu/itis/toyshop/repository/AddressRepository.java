package ru.kpfu.itis.toyshop.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.toyshop.domain.Address;
import ru.kpfu.itis.toyshop.domain.User;

/**
 * Created by Регина on 08.04.2016.
 */
@Repository
public class AddressRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public void saveAddress(String area, String city, String street, int house, int flat, int index, User user) {
        sessionFactory.getCurrentSession().save(new Address(city, street, house, flat, index, area, user));
    }

}
