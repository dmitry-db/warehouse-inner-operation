package warehouse.inneroperationscore.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import warehouse.inneroperations.ProductDto;
import warehouse.inneroperationscore.model.ProductEntity;
import warehouse.inneroperationscore.service.interfaces.ProductService;

@Slf4j
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;

    private final ModelMapper modelMapper = new ModelMapper();

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ProductDto findProductById(@RequestParam("name") String name) {
        return modelMapper.map(productService.findByName(name), ProductDto.class);
    }

    @PostMapping("/save")
    public void saveProduct(@RequestBody ProductDto productDto) {
        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        productService.save(productEntity);
        log.info("В базу добавлен новый продукт тип - {}, имя продукта - {}," +
                " стоимость - {}, количество {}", productEntity.getProductType(),
                productEntity.getName(), productEntity.getPrice(), productEntity.getCount());
    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        return modelMapper.map(productService.findById(id), ProductDto.class);
    }

    @PatchMapping
    public boolean updateProductById(@RequestBody ProductEntity productEntity) {
        boolean answer = productService.updateById(productEntity);
        log.info("В базе обновлен продукт тип - {}, имя продукта - {}," +
                        " новые значения: стоимость - {}, количество {}", productEntity.getProductType(),
                productEntity.getName(), productEntity.getPrice(), productEntity.getCount());
        return answer;
    }

    @DeleteMapping("/{name}")
    private boolean deleteProductByName(@PathVariable String name) {
        boolean answer = productService.deleteByName(name);
        log.info("Из базы удален продукт продукт. Имя продукта - {}", name);
        return answer;
    }
}
