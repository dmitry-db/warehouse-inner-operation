package warehouse.inneroperationscore.controllers;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import warehouse.inneroperations.NomenclatureDto;
import warehouse.inneroperationscore.model.NomenclatureEntity;
import warehouse.inneroperationscore.service.interfaces.NomenclatureService;

@Slf4j
@RestController
@RequestMapping("/api/nomenclature")
public class NomenclatureController {

    private final NomenclatureService nomenclatureService;

    private final ModelMapper modelMapper = new ModelMapper();

    public NomenclatureController(NomenclatureService nomenclatureService) {
        this.nomenclatureService = nomenclatureService;
    }

    @PostMapping("/save")
    public int saveNomenclature(@RequestBody NomenclatureEntity nomenclatureEntity) {
        int answer =  nomenclatureService.insert(nomenclatureEntity);
        log.info("В номенклатуру добавлен новый товар. Тип товара - {}, имя товара - {}",
                nomenclatureEntity.getProductType(), nomenclatureEntity.getProductName());
        return answer;
    }

    @GetMapping("/{id}")
    public NomenclatureDto findNomenclatureById(@PathVariable Long id) {
        return modelMapper.map(nomenclatureService.findById(id), NomenclatureDto.class);
    }

    @DeleteMapping("/{id}")
    public boolean deleteNomenclatureById(@PathVariable Long id) {
        NomenclatureEntity nomenclatureEntity = nomenclatureService.findById(id);
        boolean answer = nomenclatureService.deleteById(id);
        if (nomenclatureEntity != null) {       //вернись сюда
            log.info("Из номенклатуры был удален товар. Тип товара - {}, имя товара - {}",
                    nomenclatureEntity.getProductType(), nomenclatureEntity.getProductName());
        }
        return answer;
    }
}
