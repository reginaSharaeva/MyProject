package ru.dz.labs.api.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.domain.TutorInfo;

import java.util.List;

/**
 * @author Gataullin Kamil
 *         24.11.2014 22:41
 */
@Service
public class TutorService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @SuppressWarnings("unchecked")
    public List<TutorInfo> getAllTutor() {
        return sessionFactory.getCurrentSession().createCriteria(TutorInfo.class).list();
    }

    @Transactional
    public void add(TutorInfo tutorInfo) {
        sessionFactory.getCurrentSession().save(tutorInfo);
    }
}
