package ru.dz.labs.api.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.domain.CityInfo;

/**
 * @author Gataullin Kamil
 *         24.11.2014 23:00
 */
@Service
public class CityService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void add(CityInfo cityInfo) {
        sessionFactory.getCurrentSession().save(cityInfo);
    }
}
