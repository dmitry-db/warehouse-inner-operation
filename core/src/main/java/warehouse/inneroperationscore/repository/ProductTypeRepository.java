package warehouse.inneroperationscore.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import warehouse.inneroperations.ProductTypeDto;

@Mapper
public interface ProductTypeRepository {

//    TypeProductDto findByType(@Param("type") String type);
//
//    int insert(@Param("productName") String productName);
//
//    List<TypeProductDto> findAll();
//
//    int insertAll(@Param("productNameList") List<String> productNameList);
//
//    Boolean updateByName(@Param("productName") String productName);
//
//    Boolean deleteByProductName(@Param("productName") String productName);

      ProductTypeDto findById(@Param("name") String name);
}
