package ru.dz.labs.api.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.api.domain.CityInfo;

/**
 * Gataullin Kamil
 * 05.12.2015 21:03
 */
@Repository
public class CityRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(CityInfo cityInfo) {
        sessionFactory.getCurrentSession().save(cityInfo);
    }
}
