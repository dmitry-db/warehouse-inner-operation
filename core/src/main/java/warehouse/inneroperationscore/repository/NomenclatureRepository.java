package warehouse.inneroperationscore.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import warehouse.inneroperations.NomenclatureDto;
import warehouse.inneroperations.TypeProductDto;
import warehouse.inneroperationscore.model.Nomenclature;

import java.util.List;

@Mapper
public interface NomenclatureRepository {

    NomenclatureDto findById(@Param("id") Long id);

    int insert(@Param("nomenclature") Nomenclature nomenclature);

    List<NomenclatureDto> findByIds(@Param("productIds") List<Long> productIds);

    int insertAll(@Param("nomenclatureList") List<Nomenclature> nomenclatureList);

    Boolean updateByProduct(@Param("product") Long Product4895
            , @Param("count") Long count);

    Boolean deleteById(@Param("id") Long id);
}
