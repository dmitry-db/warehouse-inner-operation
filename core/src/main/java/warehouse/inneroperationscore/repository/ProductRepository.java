package warehouse.inneroperationscore.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import warehouse.inneroperationscore.model.ProductEntity;

import java.util.List;

@Mapper
public interface ProductRepository {

    @Select("select * from products where name = #{name}")
    ProductEntity findByName(String name);

    @Insert("insert into products (product_type, name, price, count) " +
            "values(#{productType}, #{name}, #{price}, #{count})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(ProductEntity productEntity);

    @Select("select * from products where id = #{id}")
    ProductEntity findById(Long id);

//    int insertAll(@Param("products") List<ProductEntity> productEntities);
//
    @Update("update products set price = #{price}, count = #{count} " +
        "where id = #{id}")
    Boolean updateById(ProductEntity productEntity);

    @Delete("delete from products where name = #{name}")
    Boolean deleteByName(String name);
}
