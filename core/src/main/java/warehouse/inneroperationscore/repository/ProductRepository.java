package warehouse.inneroperationscore.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import warehouse.inneroperations.ProductDto;
import warehouse.inneroperationscore.model.ProductEntity;

import java.util.List;

@Mapper
public interface ProductRepository {

    @Select("select p.id, p.nomenclature_id," +
            "n.product_type, n.product_name," +
            "p.price, p.count " +
            "from products as p " +
            "inner join nomenclature as n on n.id = p.nomenclature_id" +
            " where p.id = #{id}")
    ProductDto findById(Long id);

    @Select("select p.id, p.nomenclature_id," +
            "n.product_type, n.product_name," +
            "p.price, p.count " +
            "from products as p " +
            "inner join nomenclature as n on n.id = p.nomenclature_id" +
            " where p.nomenclature_id = #{id}")
    ProductDto findByNomenclatureId(Long id);

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
