package warehouse.inneroperationscore.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SaleRepository {

    @Update("update products set count = count - #{count} " +
            "where name = #{name}")
    boolean saleProduct(@Param("name") String name, @Param("count") Long count);
}
