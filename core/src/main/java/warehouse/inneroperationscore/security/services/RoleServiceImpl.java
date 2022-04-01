package warehouse.inneroperationscore.security.services;

import org.springframework.stereotype.Service;
import warehouse.inneroperationscore.security.model.Role;
import warehouse.inneroperationscore.security.repositories.RoleRepository;
import warehouse.inneroperationscore.security.services.interfaces.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAllRoles();
    }

    @Override
    public Role findRoleById(Long id) {
        return roleRepository.findRoleById(id);
    }

    @Override
    public Role findRoleByName(String role) {
        return findAllRoles().stream().filter(r -> r.getName().equals(role)).findAny().orElse(null);
    }

    @Override
    public int saveRole(Role role) {
        return roleRepository.saveRole(role);
    }

    @Override
    public boolean deleteRoleById(Long id) {
        return roleRepository.deleteRoleById(id);
    }


}
