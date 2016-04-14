package ru.kpfu.itis.toyshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.toyshop.domain.User;
import ru.kpfu.itis.toyshop.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * Gataullin Kamil
 * 28.03.2016 20:55
 */
@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Autowired
    private HttpSession session;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.getUserByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User with name " + login + " not found");
        }
        MyUserDetail myUserDetail = new MyUserDetail(user);
        session.setAttribute("userLogin", myUserDetail.getUsername());
        return myUserDetail;
    }

}
