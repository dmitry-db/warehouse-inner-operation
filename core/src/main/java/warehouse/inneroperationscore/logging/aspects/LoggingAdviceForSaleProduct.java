package warehouse.inneroperationscore.logging.aspects;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import warehouse.inneroperations.ProductDto;
import warehouse.inneroperationscore.constants.Constants;
import warehouse.inneroperationscore.service.interfaces.ProductService;

@Slf4j
@Aspect
@Component
public class LoggingAdviceForSaleProduct {

    private final ProductService productService;

    public LoggingAdviceForSaleProduct(ProductService productService) {
        this.productService = productService;
    }

    @Pointcut("execution(public * warehouse.inneroperationscore.controllers.SaleController.*(..))")
    public void saleMethod() {
    }

    @Around("saleMethod()")
    public Object productControllerMethod(ProceedingJoinPoint pjp) throws JsonProcessingException {
        Object[] args = pjp.getArgs();
        ProductDto productDto = productService.findByNomenclatureId((Long) args[0]);
        Object object = null;
        try {
            object = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        if ((boolean) object) {
            Long count = (Long) args[1];
            log.info("Продано товара тип - {}, имя - {}: в количестве - {}",
                    productDto.getProductType(), productDto.getProductName(), count);
            Constants.addSum(count * productDto.getPrice());
            System.out.println(Constants.getProfitOnDay());
        }
        return object;
    }
}
