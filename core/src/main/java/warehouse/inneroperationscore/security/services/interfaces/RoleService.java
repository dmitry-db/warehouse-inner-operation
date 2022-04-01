package warehouse.inneroperationscore.security.services.interfaces;

import warehouse.inneroperationscore.security.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAllRoles();

    Role findRoleById(Long id);

    Role findRoleByName(String role);

    int saveRole(Role role);

    boolean deleteRoleById(Long id);

}