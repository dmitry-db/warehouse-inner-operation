package warehouse.inneroperationscore.service;

import org.springframework.stereotype.Service;
import warehouse.inneroperations.ProductDto;
import warehouse.inneroperationscore.model.ProductEntity;
import warehouse.inneroperationscore.repository.ProductRepository;
import warehouse.inneroperationscore.service.interfaces.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(ProductEntity productEntity) {
        productRepository.insert(productEntity);
    }

    @Override
    public ProductEntity findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductEntity findByNomenclatureId(Long id) {
        return productRepository.findByNomenclatureId(id);
    }

    @Override
    public boolean updateByNomenclatureId(ProductEntity productEntity) {
        return productRepository.updateByNomenclatureId(productEntity);
    }

    @Override
    public Boolean deleteByNomenclatureId(Long id) {
        return productRepository.deleteByNomenclatureId(id);
    }
}
