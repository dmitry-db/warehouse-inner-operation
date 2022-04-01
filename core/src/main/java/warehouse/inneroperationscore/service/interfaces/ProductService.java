package warehouse.inneroperationscore.service.interfaces;

import org.apache.ibatis.annotations.Param;
import warehouse.inneroperations.ProductDto;
import warehouse.inneroperationscore.model.ProductEntity;

public interface ProductService {

    void save(ProductEntity productEntity);

    ProductEntity findByNomenclatureId(Long id);

    ProductEntity findById(Long id);

    boolean updateByNomenclatureId(ProductEntity productEntity);

    Boolean deleteByNomenclatureId(Long id);
}
