package warehouse.inneroperationscore.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SaleRepository {

    @Update("update products set count = count - #{count} " +
            "where nomenclature_id = #{id}")
    boolean saleProduct(@Param("id") Long id, @Param("count") Long count);
}
