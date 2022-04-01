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
    public ProductEntity findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public ProductEntity findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean updateById(ProductEntity productEntity) {
        return productRepository.updateById(productEntity);
    }

    @Override
    public Boolean deleteByName(String name) {
        return productRepository.deleteByName(name);
    }
}
