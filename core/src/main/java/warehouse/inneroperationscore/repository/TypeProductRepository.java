package warehouse.inneroperationscore.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import warehouse.inneroperations.TypeProductDto;

import java.util.List;

@Mapper
public interface TypeProductRepository {

    TypeProductDto findByType(@Param("type") String type);

    int insert(@Param("productName") String productName);

    List<TypeProductDto> findAll();

    int insertAll(@Param("productNameList") List<String> productNameList);

    Boolean updateByName(@Param("productName") String productName);

    Boolean deleteByProductName(@Param("productName") String productName);
}
