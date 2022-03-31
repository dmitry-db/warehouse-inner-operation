package warehouse.inneroperationscore.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import warehouse.inneroperations.ProductDto;
import warehouse.inneroperations.TypeProductDto;
import warehouse.inneroperationscore.model.Product;

import java.util.List;

@Mapper
public interface ProductRepository {

    ProductDto findByType(@Param("productType") String productType,
                          @Param("productName") String productName);

    int insert(@Param("product") Product product);

    int insertAll(@Param("products") List<Product> products);

    Boolean updateById(@Param("product") Product product);

    Boolean deleteById(@Param("id") Long id);
}
