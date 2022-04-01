package warehouse.inneroperationscore.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import warehouse.inneroperationscore.model.NomenclatureEntity;

@Mapper
public interface NomenclatureRepository {

    @Select("select * from nomenclature where id = #{id}")
    NomenclatureEntity findById(@Param("id") Long id);

    @Insert("insert into nomenclature (product_type, product_name) " +
            "values(#{productType}, #{productName})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(NomenclatureEntity nomenclatureEntity);

    @Delete("delete from nomenclature where id = #{id}")
    Boolean deleteById(@Param("id") Long id);

}
