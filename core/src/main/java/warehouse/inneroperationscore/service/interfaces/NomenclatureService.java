package warehouse.inneroperationscore.service.interfaces;

import warehouse.inneroperationscore.model.NomenclatureEntity;

public interface NomenclatureService {

    NomenclatureEntity findById(Long id);

    int insert(NomenclatureEntity nomenclatureEntity);

    Boolean deleteById(Long id);
}
