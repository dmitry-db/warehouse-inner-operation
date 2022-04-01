package warehouse.inneroperationscore.sheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import warehouse.inneroperationscore.constants.Constants;
import warehouse.inneroperationscore.model.ProfitEntity;
import warehouse.inneroperationscore.service.interfaces.ProfitService;

import java.time.LocalDate;

@Slf4j
@Component
public class EventCreator {

    private final ProfitService profitService;

    public EventCreator(ProfitService profitService) {
        this.profitService = profitService;
    }

    @Scheduled(zone = "GMT+3:00", cron = "59 59 23 * * ?")
    public void create() {
        log.info("profit on day");
        ProfitEntity profitEntity = new ProfitEntity(LocalDate.now(), Constants.getProfitOnDay());
        profitService.save(profitEntity);
        Constants.setProfitOnDayNull();
    }
}
