package warehouse.inneroperationscore.logging.aspects;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import warehouse.inneroperations.ProductDto;

@Slf4j
@Aspect
@Component
public class LoggingAdviceForSaleProduct {

    @Pointcut("execution(public * warehouse.inneroperationscore.controllers.SaleController.*(..))")
    public void saleMethod() {
    }

    @Around("saleMethod()")
    public Object productControllerMethod(ProceedingJoinPoint pjp) throws JsonProcessingException {
        Object[] args = pjp.getArgs();
        ProductDto productDto = (ProductDto) args[0];
        log.info("Продано товара тип - {}, имя - {}: в количестве - {}",
                productDto.getProductType(), productDto.getProductName(), productDto.getCount());

        Object object = null;
        try {
            object = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return object;
    }
}
