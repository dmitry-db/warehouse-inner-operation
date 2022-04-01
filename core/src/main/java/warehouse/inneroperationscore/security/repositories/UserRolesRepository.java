package warehouse.inneroperationscore.security.repositories;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRolesRepository {

    @Select("select roles_id from user_roles where user_id = #{id}")
    List<Long> findByUserId(Long id);

    @Delete("delete from user_roles where user_id = #{id}")
    void deleteByUserId(Long id);

    @Insert("insert into user_roles (user_id, roles_id) " +
            "values(#{userId}, #{roleId})")
    void insert(@Param("userId") Long userId, @Param("roleId") Long roleId);
}
