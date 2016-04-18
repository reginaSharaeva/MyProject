package ru.kpfu.itis.toyshop.repository;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
    public void saveAddress(Address address) {
        sessionFactory.getCurrentSession().save(address);
    }

    public Address getAddress(Address address) {
        return (Address) sessionFactory.getCurrentSession().createCriteria(Address.class).add(Restrictions.and(Restrictions.eq("area", address.getArea())).add(Restrictions.eq("city", address.getCity()))
                .add(Restrictions.eq("street", address.getStreet())).add(Restrictions.eq("house", address.getHouse()))
                .add(Restrictions.eq("flat", address.getFlat())).add(Restrictions.eq("index", address.getIndex()))).uniqueResult();
    }

}
