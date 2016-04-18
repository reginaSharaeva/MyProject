package ru.kpfu.itis.toyshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.toyshop.domain.Address;
import ru.kpfu.itis.toyshop.repository.AddressRepository;

/**
 * Created by Регина on 17.04.2016.
 */
@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void addAddress(Address address) {
        if (addressRepository.getAddress(address) == null) {
            addressRepository.saveAddress(address);
        }
    }
}
