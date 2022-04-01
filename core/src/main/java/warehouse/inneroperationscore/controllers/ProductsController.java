package warehouse.inneroperationscore.controllers;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/nomenclature/{id}")
    public ProductDto findProductByNomenclatureId(@PathVariable Long id) {
        return modelMapper.map(productService.findByNomenclatureId(id), ProductDto.class);
    }

    @PostMapping("/save")
    public void saveProduct(@RequestBody ProductDto productDto) {
        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        productService.save(productEntity);
//        log.info("В базу добавлен новый продукт тип - {}, имя продукта - {}," +
//                " стоимость - {}, количество {}", productDto.getProductType(),
//                productDto.getProductName(), productDto.getPrice(), productDto.getCount());
    }


    @PatchMapping
    public boolean updateProductById(@RequestBody ProductDto productDto) {
        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        boolean answer = productService.updateByNomenclatureId(productEntity);
//        log.info("В базе обновлен продукт тип - {}, имя продукта - {}," +
//                        " новые значения: стоимость - {}, количество {}", productDto.getProductType(),
//                productDto.getProductName(), productDto.getPrice(), productDto.getCount());
        return answer;
    }

    @DeleteMapping("/{id}")
    public boolean deleteProductByNomenclatureId(@PathVariable Long id) {
        ProductDto productDto = productService.findByNomenclatureId(id);
        boolean answer = productService.deleteByNomenclatureId(id);
//        log.info("Из базы удален продукт продукт. Тип продукта - {}, имя продукта - {}" +
//                ", количество которого на складе {}", productDto.getProductType(),
//                productDto.getProductName(), productDto.getCount());
        return answer;
    }
}
