package warehouse.inneroperationscore.service.interfaces;

import warehouse.inneroperations.ProductDto;
import warehouse.inneroperationscore.model.ProductEntity;

public interface ProductService {

    void save(ProductEntity productEntity);

    ProductEntity findByTypeAndName(String type, String name);

    ProductEntity findById(Long id);
}
