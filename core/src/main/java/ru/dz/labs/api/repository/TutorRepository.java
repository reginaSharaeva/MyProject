package ru.dz.labs.api.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.api.domain.TutorInfo;

import java.util.List;

/**
 * Gataullin Kamil
 * 05.12.2015 21:10
 */
@Repository
public class TutorRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<TutorInfo> getAllTutor() {
        return sessionFactory.getCurrentSession().createCriteria(TutorInfo.class).list();
    }

    public void add(TutorInfo tutorInfo) {
        sessionFactory.getCurrentSession().save(tutorInfo);
    }
}
