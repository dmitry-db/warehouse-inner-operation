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
    public ProductEntity findByTypeAndName(String type, String name) {
        return productRepository.findByTypeAndName(type, name);
    }

    @Override
    public ProductEntity findById(Long id) {
        return productRepository.findById(id);
    }
}
