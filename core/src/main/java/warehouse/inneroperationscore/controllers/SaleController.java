package warehouse.inneroperationscore.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import warehouse.inneroperations.ProductDto;
import warehouse.inneroperationscore.service.interfaces.ProductService;
import warehouse.inneroperationscore.service.interfaces.SaleService;

@Slf4j
@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleService saleService;
    private final ProductService productService;

    public SaleController(SaleService saleService, ProductService productService) {
        this.saleService = saleService;
        this.productService = productService;
    }

    //через request param, доставать id и количетсво купленных единиц
    //(не знал логично ли передавать json c моделью для этой цели, т.к. нужно лишь id и количество купленного товара
    @GetMapping
    public boolean saleProductByNomenclatureId(@RequestParam("id") Long id, @RequestParam("count") Long count) {
        boolean answer = saleService.saleProductByNomenclatureId(id, count);
        ProductDto productDto = productService.findByNomenclatureId(id);
        if (productDto != null) {       //если останется время вернуться, написать логику, если количестов покупаемых больше чем есть на складе
            log.info("Продано товара тип - {}, имя - {}: в количестве - {}, осталось - {}",
                    productDto.getProductType(), productDto.getProductName(), count, productDto.getCount());
        }
        return answer;
    }
}
