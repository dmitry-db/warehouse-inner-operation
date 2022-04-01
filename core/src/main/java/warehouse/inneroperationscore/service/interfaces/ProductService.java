package warehouse.inneroperationscore.service.interfaces;

import org.apache.ibatis.annotations.Param;
import warehouse.inneroperations.ProductDto;
import warehouse.inneroperationscore.model.ProductEntity;

public interface ProductService {

    void save(ProductEntity productEntity);

    ProductEntity findByName(String name);

    ProductEntity findById(Long id);

    boolean updateById(ProductEntity productEntity);

    Boolean deleteByName(String name);
}
