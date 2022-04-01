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

    @Select("select * from products where id = #{id}")
    ProductEntity findById(Long id);

    @Select("select * from products where nomenclature_id = #{id}")
    ProductEntity findByNomenclatureId(Long id);

    @Insert("insert into products (nomenclature_id, price, count) " +
            "values(#{nomenclatureId}, #{price}, #{count})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(ProductEntity productEntity);

    @Update("update products set price = #{price}, count = #{count} " +
        "where nomenclature_id = #{nomenclatureId}")
    Boolean updateByNomenclatureId(ProductEntity productEntity);

    @Delete("delete from products where nomenclature_id = #{id}")
    Boolean deleteByNomenclatureId(Long id);
}
