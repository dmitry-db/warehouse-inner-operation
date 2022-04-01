package warehouse.inneroperationscore.service;

import org.springframework.stereotype.Service;
import warehouse.inneroperationscore.model.ProfitEntity;
import warehouse.inneroperationscore.repository.ProfitRepository;
import warehouse.inneroperationscore.service.interfaces.ProfitService;

@Service
public class ProfitServiceImpl implements ProfitService {

    private final ProfitRepository profitRepository;

    public ProfitServiceImpl(ProfitRepository profitRepository) {
        this.profitRepository = profitRepository;
    }

    @Override
    public void save(ProfitEntity profitEntity) {
        profitRepository.insert(profitEntity);
    }
}
