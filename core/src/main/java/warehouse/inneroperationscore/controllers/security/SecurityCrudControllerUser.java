package warehouse.inneroperationscore.controllers.security;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import warehouse.inneroperationscore.security.model.UserEntity;
import warehouse.inneroperationscore.security.services.interfaces.UserSecurityService;

import java.util.List;

@RestController
@RequestMapping("/api/security/user")
public class SecurityCrudControllerUser {

    public final UserSecurityService userSecurityService;

    public SecurityCrudControllerUser(UserSecurityService userSecurityService) {
        this.userSecurityService = userSecurityService;
    }

    @GetMapping("/all")
    public List<UserEntity> findAllUsers() {
        return userSecurityService.findAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntity findUserByLogin(@PathVariable Long id) {
        return userSecurityService.findUserById(id);
    }

//    как альтернатива
//    @GetMapping("/{login}")
//    public UserEntity findUserByLogin(@PathVariable String login) {
//        return userSecurityService.findUserByLogin(login);
//    }

    @PostMapping("/save")
    public int saveUser(@RequestBody UserEntity user) {
        return userSecurityService.saveUser(user);
    }

    @PatchMapping
    public boolean updateUser(UserEntity user) {
        return userSecurityService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return userSecurityService.deleteUser(id);
    }
}
