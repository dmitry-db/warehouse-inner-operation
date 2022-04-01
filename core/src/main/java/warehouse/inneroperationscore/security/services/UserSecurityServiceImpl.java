package warehouse.inneroperationscore.security.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import warehouse.inneroperationscore.security.model.Role;
import warehouse.inneroperationscore.security.model.UserEntity;
import warehouse.inneroperationscore.security.repositories.UserSecurityRepository;
import warehouse.inneroperationscore.security.services.interfaces.UserSecurityService;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class UserSecurityServiceImpl implements UserSecurityService {

    private final UserSecurityRepository userSecurityRepository;
    private PasswordEncoder passwordEncoder;

    public UserSecurityServiceImpl(UserSecurityRepository userSecurityRepository) {
        this.userSecurityRepository = userSecurityRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(10);
    }


    @Override
    public List<UserEntity> findAllUsers() {
        return userSecurityRepository.findAllUsers();
    }

    @Override
    public UserEntity findUserById(Long id) {
        return userSecurityRepository.findUserById(id);
    }

    @Override
    public UserEntity findUserByLogin(String login) {
        return userSecurityRepository.findUserByLogin(login);
    }

    @Override
    public int saveUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        return userSecurityRepository.saveUser(user);
    }

    @Override
    public boolean updateUser(UserEntity user) {
        return userSecurityRepository.updateUser(user);
    }

    @Override
    public boolean deleteUser(Long id) {
        return userSecurityRepository.deleteUser(findUserById(id));
    }

    @Override
    public Set<Role> getListRoles(Long id) {
        return userSecurityRepository.getListRoles(id);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity user = userSecurityRepository.findUserByLogin(login);
        try {
            user.setRoles(userSecurityRepository.getListRoles(user.getId()));
        } catch (NullPointerException e) {
            log.warn("пользователя с login {} не существует", login);
        }
        return user;
    }
}
