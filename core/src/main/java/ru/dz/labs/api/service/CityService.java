package ru.dz.labs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.domain.CityInfo;
import ru.dz.labs.api.repository.CityRepository;

/**
 * @author Gataullin Kamil
 *         24.11.2014 23:00
 */
@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Transactional
    public void add(CityInfo cityInfo) {
        cityRepository.add(cityInfo);
    }
}
