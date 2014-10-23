package ru.dz.labs.api.service;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ru.dz.labs.api.domain.SubjectInfo;
import ru.dz.labs.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gataullin Kamil
 *         06.10.2014 1:46
 */
public class SubjectService {

    public void addSubject(SubjectInfo subject) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(subject);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Error in addSubject()");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateSubject(SubjectInfo subject) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(subject);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Error in updateSubject()");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public SubjectInfo getSubjectById(Long id) {
        Session session = null;
        SubjectInfo subject = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            subject = (SubjectInfo) session.createCriteria(SubjectInfo.class)
                    .add(Restrictions.eq("id", id)).uniqueResult();
        } catch (Exception e) {
            System.err.println("Error in getSubjectById()");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return subject;
    }

    public List<SubjectInfo> getAllSubjects() {
        Session session = null;
        List<SubjectInfo> subjects = new ArrayList<SubjectInfo>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            subjects = session.createCriteria(SubjectInfo.class).list();
        } catch (Exception e) {
            System.err.println("Error in getAllSubjects()");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return subjects;
    }

    public void deleteSubject(SubjectInfo subject) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(subject);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Error in deleteSubject()");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
