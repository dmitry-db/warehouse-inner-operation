package warehouse.inneroperationscore.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import warehouse.inneroperations.ProductDto;
import warehouse.inneroperationscore.logging.annotation.Loggable;
import warehouse.inneroperationscore.service.interfaces.SaleService;

@Slf4j
@Loggable
@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PatchMapping
    public boolean saleProductByNomenclatureId(@RequestBody ProductDto productDto) {
        boolean answer = saleService.saleProductByNomenclatureId(productDto);
//        if (productDto != null) {       //если останется время вернуться, написать логику, если количестов покупаемых больше чем есть на складе
//            log.info("Продано товара тип - {}, имя - {}: в количестве - {}, осталось - {}",
//                    productDto.getProductType(), productDto.getProductName(), productDto.getCount(),
//                    productDto.getCount());
//        }
        return answer;
    }
}
