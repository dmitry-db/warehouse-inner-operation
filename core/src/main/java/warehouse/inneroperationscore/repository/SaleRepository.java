package warehouse.inneroperationscore.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import warehouse.inneroperations.ProductDto;

@Mapper
public interface SaleRepository {

    @Update("update products set count = count - #{count} " +
            "where nomenclature_id = #{nomenclatureId}")
    boolean saleProduct(ProductDto productDto);
}
