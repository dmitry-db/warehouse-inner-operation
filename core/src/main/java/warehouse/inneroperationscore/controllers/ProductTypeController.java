package warehouse.inneroperationscore.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import warehouse.inneroperations.ProductTypeDto;
import warehouse.inneroperationscore.service.interfaces.ProductTypeService;

@RestController
@RequestMapping("/api/product-type")
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    private ModelMapper modelMapper = new ModelMapper();

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping("/{name}")
    public ProductTypeDto findByName(@PathVariable String name) {
        return productTypeService.findById(name);
    }
}
