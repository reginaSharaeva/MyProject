package ru.dz.labs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.domain.SubjectInfo;
import ru.dz.labs.api.repository.SubjectRepository;

import java.util.List;

/**
 * @author Gataullin Kamil
 *         06.10.2014 1:46
 */
@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Transactional
    public List<SubjectInfo> getAllSubjects() {
        return subjectRepository.getAllSubjects();
    }

    @Transactional
    public void addSubject(SubjectInfo subject) {
        subjectRepository.addSubject(subject);
    }

    @Transactional
    public void updateSubject(SubjectInfo subject) {
        subjectRepository.updateSubject(subject);
    }

    @Transactional
    public SubjectInfo getSubjectById(Long id) {
        return subjectRepository.getSubjectById(id);
    }

    @Transactional
    public void deleteSubject(SubjectInfo subject) {
        subjectRepository.deleteSubject(subject);
    }
}
