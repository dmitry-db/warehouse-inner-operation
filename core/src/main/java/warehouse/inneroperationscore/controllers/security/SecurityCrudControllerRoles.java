package warehouse.inneroperationscore.controllers.security;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import warehouse.inneroperationscore.security.model.Role;
import warehouse.inneroperationscore.security.services.interfaces.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/security/roles")
public class SecurityCrudControllerRoles {

    private final RoleService roleService;

    public SecurityCrudControllerRoles(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public List<Role> findAllRoles() {
        return roleService.findAllRoles();
    }

    @GetMapping("/{id}")
    public Role findRoleById(@PathVariable Long id) {
        return roleService.findRoleById(id);
    }

    @PostMapping("/save")
    public int saveRole(Role role) {
        return roleService.saveRole(role);
    }

    @DeleteMapping("/{id}")
    public boolean deleteRoleById(@PathVariable Long id) {
        return roleService.deleteRoleById(id);
    }
}
