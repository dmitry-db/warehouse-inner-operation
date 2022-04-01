package warehouse.inneroperationscore.service.interfaces;

import warehouse.inneroperations.ProductDto;
import warehouse.inneroperationscore.model.ProductEntity;

public interface ProductService {

    void save(ProductEntity productEntity);

    ProductDto findByNomenclatureId(Long id);

    ProductDto findById(Long id);

    boolean updateByNomenclatureId(ProductEntity productEntity);

    Boolean deleteByNomenclatureId(Long id);
}
