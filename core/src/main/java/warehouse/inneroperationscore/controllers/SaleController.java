package warehouse.inneroperationscore.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import warehouse.inneroperationscore.service.interfaces.SaleService;

@Slf4j
@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public boolean saleProduct(@RequestParam("name") String name, @RequestParam("count") Long count) {
        boolean answer = saleService.saleProduct(name, count);
        log.info("Продано товара имя - {}, в количестве - {}", name, count);
        return answer;
    }
}
