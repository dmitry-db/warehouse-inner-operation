package warehouse.inneroperationscore.logging.aspects;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import warehouse.inneroperations.ProductDto;
import warehouse.inneroperationscore.service.interfaces.ProductService;

@Slf4j
@Aspect
@Component
public class LoggingAdviceForProductController {

    private final ProductService productService;

    public LoggingAdviceForProductController(ProductService productService) {
        this.productService = productService;
    }

    @Pointcut("execution(public * warehouse.inneroperationscore.controllers.ProductsController.*(..))")
    public void productMethod() {
    }

    @Around("productMethod()")
    public Object productAdviceMethod(ProceedingJoinPoint pjp) throws JsonProcessingException {
        Object[] args = pjp.getArgs();
        String methodName = pjp.getSignature().getName();
        switch (methodName) {
            case "saveProduct": {
                ProductDto productDto = (ProductDto) args[0];
                log.info("В базу добавлен новый продукт тип - {}, имя продукта - {}," +
                                " стоимость - {}, количество {}", productDto.getProductType(),
                        productDto.getProductName(), productDto.getPrice(), productDto.getCount());
                break;
            }
            case "updateProductById": {
                ProductDto productDto = (ProductDto) args[0];
                log.info("В базе обновлен продукт тип - {}, имя продукта - {}," +
                                " новые значения: стоимость - {}, количество {}", productDto.getProductType(),
                        productDto.getProductName(), productDto.getPrice(), productDto.getCount());
                break;
            }
            case "deleteProductByNomenclatureId": {
                Long id = (Long) args[0];
                ProductDto productDto = productService.findByNomenclatureId(id);
                log.info("Из базы удален продукт продукт. Тип продукта - {}, имя продукта - {}" +
                                ", количество которого на складе {}", productDto.getProductType(),
                        productDto.getProductName(), productDto.getCount());
                break;
            }
        }

        Object object = null;
        try {
            object = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return object;
    }
}
