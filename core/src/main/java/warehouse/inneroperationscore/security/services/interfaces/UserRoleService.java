package warehouse.inneroperationscore.security.services.interfaces;

import java.util.List;

public interface UserRoleService {

    List<Long> findByUserId(Long id);

    void save(Long userId, Long roleId);

    void deleteByUserId(Long id);
}
