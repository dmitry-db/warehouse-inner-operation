package warehouse.inneroperationscore.controllers;

//import org.modelmapper.ModelMapper;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import warehouse.inneroperations.ProductDto;
//import warehouse.inneroperations.ProductTypeDto;
//import warehouse.inneroperationscore.model.ProductEntity;
//import warehouse.inneroperationscore.model.ProductTypeEntity;
//import warehouse.inneroperationscore.service.interfaces.ProductTypeService;
//
//@RestController
//@RequestMapping("/api/product-type")
//public class ProductTypeController {
//
//    private final ProductTypeService productTypeService;
//
//    private final ModelMapper modelMapper = new ModelMapper();
//
//    public ProductTypeController(ProductTypeService productTypeService) {
//        this.productTypeService = productTypeService;
//    }
//
//    @PostMapping("/save")
//    public int saveProductType(@RequestBody ProductTypeDto productTypeDto) {
//        System.out.println(productTypeDto);
//        int answer = productTypeService.insert(modelMapper.map(productTypeDto, ProductTypeEntity.class));
//        return answer;
//    }
//
//    @DeleteMapping("/{name}")
//    public boolean deleteProductTypeByName(@PathVariable String name) {
//        boolean answer =productTypeService.deleteByName(name);
//        return answer;
//    }
//}
