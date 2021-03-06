package warehouse.inneroperationscore.controllers.sale;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import warehouse.inneroperations.ProductDto;
import warehouse.inneroperationscore.logging.annotation.Loggable;
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

    @GetMapping
    public boolean saleProductByNomenclatureId(@RequestParam("id") Long id, @RequestParam("count") Long count) {
        ProductDto productDtoInWarehouse = productService.findByNomenclatureId(id);
        if (productDtoInWarehouse.getCount() < count) {
            log.warn("Не хватает количества товара на слкаде. В покупке - {}, на складе - {}",          // можно в будущем обработать с помощью exceptionHandler
                    count, productDtoInWarehouse.getCount());
            return false;
        }
        return saleService.saleProductByNomenclatureId(id, count);
    }
}
