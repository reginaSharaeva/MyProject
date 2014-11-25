package ru.dz.labs.api.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.domain.SubjectInfo;

import java.util.List;

/**
 * @author Gataullin Kamil
 *         06.10.2014 1:46
 */
@Service
public class SubjectService {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Transactional
    public List<SubjectInfo> getAllSubjects() {
        return sessionFactory.getCurrentSession().createCriteria(SubjectInfo.class).list();
    }

    @Transactional
    public void addSubject(SubjectInfo subject) {
        sessionFactory.getCurrentSession().save(subject);
    }

    @Transactional
    public void updateSubject(SubjectInfo subject) {
        sessionFactory.getCurrentSession().update(subject);
    }

    @Transactional
    public SubjectInfo getSubjectById(Long id) {
        return (SubjectInfo) sessionFactory.getCurrentSession().load(SubjectInfo.class, id);
    }

    @Transactional
    public void deleteSubject(SubjectInfo subject) {
        sessionFactory.getCurrentSession().delete(subject);
    }
}
