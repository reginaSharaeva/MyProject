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


    public void addUser(String name, String mail, String password, String key) {
        HashMake hashMake = new HashMake();
        String hash_pass = hashMake.md5Apache(password);
        userRepository.addUser(name, mail, hash_pass, key);
    }

    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public boolean checkUser(String mail) {
        User user = userRepository.getUserByLogin(mail);
        if (user == null) {
            return true;
        } else {
            return false;
        }
    }

    public void changeCheck(Long userId) {
        userRepository.setTrue(userId);
    }
}

