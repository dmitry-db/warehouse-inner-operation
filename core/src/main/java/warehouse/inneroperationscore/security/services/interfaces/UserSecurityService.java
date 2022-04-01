package warehouse.inneroperationscore.security.services.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;
import warehouse.inneroperationscore.security.model.Role;
import warehouse.inneroperationscore.security.model.UserEntity;

import java.util.List;
import java.util.Set;

public interface UserSecurityService extends UserDetailsService {

    List<UserEntity> findAllUsers();

    UserEntity findUserById(Long id);

    UserEntity findUserByLogin(String login);

    int saveUser(UserEntity user);

    boolean updateUser(UserEntity user);

    boolean deleteUser(Long id);

    Set<Role> getListRoles(Long id);
}
