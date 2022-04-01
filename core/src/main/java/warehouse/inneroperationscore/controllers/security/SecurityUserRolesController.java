package warehouse.inneroperationscore.controllers.security;

import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import warehouse.inneroperationscore.security.services.interfaces.UserRoleService;

import java.util.List;

@RestController
@RequestMapping("/api/security/user-roles")
public class SecurityUserRolesController {

    private final UserRoleService userRoleService;

    public SecurityUserRolesController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping
    public void saveUserAndRoles(@RequestParam Long userId, @RequestParam Long roleId) {
        userRoleService.save(userId, roleId);
    }

    @GetMapping("/{id}")
    public List<Long> findRolesByUserId(@PathVariable Long id) {
        return userRoleService.findByUserId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteByUserId(@PathVariable Long id) {
        userRoleService.deleteByUserId(id);
    }
}
