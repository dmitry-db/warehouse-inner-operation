package warehouse.inneroperationscore.service;

import org.springframework.stereotype.Service;
import warehouse.inneroperations.ProductTypeDto;
import warehouse.inneroperationscore.repository.ProductTypeRepository;
import warehouse.inneroperationscore.service.interfaces.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    public ProductTypeServiceImpl(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public ProductTypeDto findById(String id) {
        return productTypeRepository.findById(id);
    }
}
