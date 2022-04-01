package warehouse.inneroperationscore.service.interfaces;

import org.apache.ibatis.annotations.Param;
import warehouse.inneroperationscore.model.NomenclatureEntity;
import warehouse.inneroperationscore.model.ProductEntity;

public interface NomenclatureService {

    NomenclatureEntity findById(Long id);

    int insert(NomenclatureEntity nomenclatureEntity);

    Boolean deleteById(Long id);
}
