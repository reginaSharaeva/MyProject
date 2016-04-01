package ru.kpfu.itis.toyshop.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.kpfu.itis.toyshop.domain.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Gataullin Kamil
 * 28.03.2016 21:01
 */
public class MyUserDetail implements UserDetails {

    /**
     * ������ � ������������ �� ��
     */
    private User user;

    public MyUserDetail(User user) {
        this.user = user;
    }

    /**
     * @return ��������� ���� ������� ������������
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
        return grantedAuthorities;
    }

    /**
     * hash ������ ������������
     */
    @Override
    public String getPassword() {
        return user.getHash_pass();
    }

    /**
     * ����� (���) ������������
     */
    @Override
    public String getUsername() {
        return user.getLogin();
    }

    /**
     * @return ����, ��� ���� �������� �������� ��� �� �����, �� �������
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return ����, ��� ������������ �� ������������ ���������������� �����
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * @return ����, ��� ���� �������� ������ ��� �� �����, �� �������
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @return ����, ��� ������������ ������� � �����������
     */
    @Override
    public boolean isEnabled() {
        return user.getCheck();
    }

    public User getUser() {
        return user;
    }

    public void setUserInfo(User user) {
        this.user = user;
    }
}
