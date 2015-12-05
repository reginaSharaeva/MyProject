package ru.dz.labs.api.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.api.domain.SubjectInfo;

import java.util.List;

/**
 * Gataullin Kamil
 * 05.12.2015 21:07
 */
@Repository
public class SubjectRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<SubjectInfo> getAllSubjects() {
        return sessionFactory.getCurrentSession().createCriteria(SubjectInfo.class).list();
    }

    public void addSubject(SubjectInfo subject) {
        sessionFactory.getCurrentSession().save(subject);
    }

    public void updateSubject(SubjectInfo subject) {
        sessionFactory.getCurrentSession().update(subject);
    }

    public SubjectInfo getSubjectById(Long id) {
        return (SubjectInfo) sessionFactory.getCurrentSession().load(SubjectInfo.class, id);
    }

    public void deleteSubject(SubjectInfo subject) {
        sessionFactory.getCurrentSession().delete(subject);
    }
}
