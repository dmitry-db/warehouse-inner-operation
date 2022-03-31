package warehouse.inneroperationscore.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import warehouse.inneroperationscore.model.ProductEntity;

import java.util.List;

@Mapper
public interface ProductRepository {

    @Select("select * from products where product_type = #{productType} AND name = #{productName}")
    ProductEntity findByTypeAndName(String productType,
                          String productName);

//    @Insert("insert into medical_card (client_status, med_status, registry_dt, comment) " +
//            "values(#{clientStatus}, #{medStatus}, #{registryDt}, #{comment})")
//    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(@Param("product") ProductEntity productEntity);

    @Select("select * from products where id = #{id}")
    ProductEntity findById(Long id);

//    int insertAll(@Param("products") List<ProductEntity> productEntities);
//
//    Boolean updateById(@Param("product") ProductEntity productEntity);
//
//    Boolean deleteById(@Param("id") Long id);
}
