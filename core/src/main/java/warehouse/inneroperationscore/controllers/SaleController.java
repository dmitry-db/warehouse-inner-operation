package warehouse.inneroperationscore.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import warehouse.inneroperations.ProductDto;
import warehouse.inneroperationscore.constants.Constants;
import warehouse.inneroperationscore.logging.annotation.Loggable;
import warehouse.inneroperationscore.model.ProfitEntity;
import warehouse.inneroperationscore.service.interfaces.ProductService;
import warehouse.inneroperationscore.service.interfaces.SaleService;

@Slf4j
@Loggable
@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleService saleService;
    private final ProductService productService;

    public SaleController(SaleService saleService, ProductService productService) {
        this.saleService = saleService;
        this.productService = productService;
    }

    @PatchMapping
    public boolean saleProductByNomenclatureId(@RequestBody ProductDto productDto) {
        ProductDto productDtoInWarehouse = productService.findByNomenclatureId(productDto.getNomenclatureId());
        if (productDtoInWarehouse.getCount() < productDto.getCount()) {
            log.warn("Не хватает количества товара на слкаде. В покупке - {}, на складе - {}",          // можно в будущем обработать с помощью exceptionHandler
                    productDto.getCount(), productDtoInWarehouse.getCount());
            return false;
        }
        boolean answer = saleService.saleProductByNomenclatureId(productDto);
        Constants.addSum(productDto.getCount() * productDtoInWarehouse.getPrice());
        System.out.println(Constants.getProfitOnDay());
        return answer;
    }
}
