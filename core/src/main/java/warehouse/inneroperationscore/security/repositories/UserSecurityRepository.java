package warehouse.inneroperationscore.security.repositories;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import warehouse.inneroperationscore.security.model.Role;
import warehouse.inneroperationscore.security.model.UserEntity;

import java.util.List;
import java.util.Set;

@Mapper
public interface UserSecurityRepository {

    @Select("select * from users")
    List<UserEntity> findAllUsers();

    @Select("select * from users where id = #{id}")
    UserEntity findUserById(Long id);

    @Select("select * from users where login = #{login}")
    UserEntity findUserByLogin(String login);

    @Insert("insert into users (login, password, enabled) " +
            "values(#{login}, #{password}, #{enabled})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int saveUser(UserEntity userEntity);

    @Update("update users set login = #{login}, password = #{password}, " +
            "enabled = #{enabled} " +
            "where id = #{id}")
    Boolean updateUser(UserEntity user);

    @Delete("delete from users where id = #{id}")
    boolean deletePerson(UserEntity user);

    @Select("select * from roles " +
            "where id IN (select roles_id from user_roles " +
            "where user_id = #{id})")
    Set<Role> getListRoles(Long id);
}
