package warehouse.inneroperationscore.service;


import org.springframework.stereotype.Service;
import warehouse.inneroperationscore.model.NomenclatureEntity;
import warehouse.inneroperationscore.model.ProductEntity;
import warehouse.inneroperationscore.repository.NomenclatureRepository;
import warehouse.inneroperationscore.service.interfaces.NomenclatureService;

@Service
public class NomenclatureServiceImpl implements NomenclatureService {

    private final NomenclatureRepository nomenclatureRepository;

    public NomenclatureServiceImpl(NomenclatureRepository nomenclatureRepository) {
        this.nomenclatureRepository = nomenclatureRepository;
    }

    @Override
    public NomenclatureEntity findById(Long id) {
        return nomenclatureRepository.findById(id);
    }

    @Override
    public int insert(NomenclatureEntity nomenclatureEntity) {
        return nomenclatureRepository.insert(nomenclatureEntity);
    }

    @Override
    public Boolean deleteById(Long id) {
        return nomenclatureRepository.deleteById(id);
    }
}
