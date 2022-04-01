package warehouse.inneroperationscore.logging.aspects;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import warehouse.inneroperationscore.logging.model.LogEntity;
import warehouse.inneroperationscore.logging.service.LogService;

import java.time.LocalDateTime;

@Slf4j
@Aspect
@Component
public class LoggingForWriteDatabase { //решил сделать другое логирование(сигнатуры вызывающих классов и методов) для разнообразия т.к. не до конца понял какие логи нужны

    private final LogService logService;

    public LoggingForWriteDatabase(LogService logService) {
        this.logService = logService;
    }

    @Pointcut("within(@warehouse.inneroperationscore.logging.annotation.Loggable *)")
    public void beanAnnotatedWithMonitor() {}

    @Pointcut("execution(public * *(..))")
    public void publicMethod() {}

    @Around("publicMethod() && beanAnnotatedWithMonitor()")
    public Object productControllerMethod(ProceedingJoinPoint pjp) throws JsonProcessingException {
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] args = pjp.getArgs();
        LogEntity loger = new LogEntity("restOperations", LocalDateTime.now(), methodName, className);
        logService.saveLog(loger);
        Object object = null;
        try {
            object = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return object;
    }
}
