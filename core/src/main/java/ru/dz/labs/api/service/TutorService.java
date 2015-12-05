package ru.dz.labs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.domain.TutorInfo;
import ru.dz.labs.api.repository.TutorRepository;

import java.util.List;

/**
 * @author Gataullin Kamil
 *         24.11.2014 22:41
 */
@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    @Transactional
    public List<TutorInfo> getAllTutor() {
        return tutorRepository.getAllTutor();
    }

    @Transactional
    public void add(TutorInfo tutorInfo) {
        tutorRepository.add(tutorInfo);
    }
}
