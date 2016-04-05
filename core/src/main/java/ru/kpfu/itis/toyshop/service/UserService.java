package ru.kpfu.itis.toyshop.service;

/**
 * Created by Regina on 28.12.2015.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.toyshop.HashMake;
import ru.kpfu.itis.toyshop.domain.User;
import ru.kpfu.itis.toyshop.repository.UserRepository;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public void addUser(String name, String mail, String password, String key) {
        HashMake hashMake = new HashMake();
        String hash_pass = hashMake.md5Apache(password);
        userRepository.addUser(name, mail, hash_pass, key);
    }

    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public boolean checkKey(String key) {
        User user = userRepository.getUserByKey(key);
        if (user == null) {
            return true;
        } else {
            return false;
        }
    }
}

