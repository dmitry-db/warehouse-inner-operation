package warehouse.inneroperationscore.security.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import warehouse.inneroperationscore.security.model.Role;

import java.util.List;

@Mapper
public interface RoleRepository {

    @Select("select * from roles")
    List<Role> findAllRoles();

    @Select("select * from roles where id = #{id}")
    Role findRoleById(Long id);

    @Select("select * from roles where name = #{name}")
    Role findRoleByName(String name);

    @Insert("insert into roles (id, name) " +
            "values(#{id}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int saveRole(Role role);
}
