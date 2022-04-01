package warehouse.inneroperationscore.security.services;

import org.springframework.stereotype.Service;
import warehouse.inneroperationscore.security.repositories.UserRolesRepository;
import warehouse.inneroperationscore.security.services.interfaces.UserRoleService;

import java.util.List;

@Service
public class UserRolesImpl implements UserRoleService {

    private final UserRolesRepository userRolesRepository;

    public UserRolesImpl(UserRolesRepository userRolesRepository) {
        this.userRolesRepository = userRolesRepository;
    }

    @Override
    public List<Long> findByUserId(Long id) {
        return userRolesRepository.findByUserId(id);
    }

    @Override
    public void save(Long userId, Long roleId) {
        userRolesRepository.insert(userId, roleId);
    }

    @Override
    public void deleteByUserId(Long id) {
        userRolesRepository.deleteByUserId(id);
    }
}
