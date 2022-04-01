package warehouse.inneroperationscore.logging.service;

import org.springframework.stereotype.Service;
import warehouse.inneroperationscore.logging.model.LogEntity;
import warehouse.inneroperationscore.logging.repositories.LogRepository;

@Service
public class LogService {

    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void saveLog(LogEntity logEntity) {
        logRepository.insert(logEntity);
    }
}
