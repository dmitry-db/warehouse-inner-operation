package warehouse.inneroperationscore.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import warehouse.inneroperations.ProductTypeDto;
import warehouse.inneroperationscore.model.ProductEntity;
import warehouse.inneroperationscore.model.ProductTypeEntity;

//@Mapper
//public interface ProductTypeRepository {
//
////    TypeProductDto findByType(@Param("type") String type);
////
////    int insert(@Param("productName") String productName);
////
////    List<TypeProductDto> findAll();
////
////    int insertAll(@Param("productNameList") List<String> productNameList);
////
////    Boolean updateByName(@Param("productName") String productName);
////
////    Boolean deleteByProductName(@Param("productName") String productName);
//
////      ProductTypeDto findById(@Param("name") String name);
//
//      @Insert("insert into type_product " +
//              "values(#{name})")
//      @Options(useGeneratedKeys = false, keyProperty = "name", keyColumn = "name")
//      int insert(ProductTypeEntity productTypeEntity);
//
//      @Delete("delete from type_product where name = #{name}")
//      Boolean deleteByName(String name);
//}
