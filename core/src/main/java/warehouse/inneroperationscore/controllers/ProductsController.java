package warehouse.inneroperationscore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import warehouse.inneroperations.ProductDto;
import warehouse.inneroperationscore.model.ProductEntity;
import warehouse.inneroperationscore.service.interfaces.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;

    private ModelMapper modelMapper = new ModelMapper();

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ProductDto findByTypeAndName(@RequestParam("type") String type, @RequestParam("name") String name) {
        return modelMapper.map(productService.findByTypeAndName(type, name), ProductDto.class);
    }

    @PostMapping("/save")
    public void saveProduct(@RequestBody ProductDto productDto) {
        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        productService.save(productEntity);
    }

    @GetMapping("/{id}")
    public ProductEntity getAddressById(@PathVariable Long id) {
        return productService.findById(id);
    }
}
