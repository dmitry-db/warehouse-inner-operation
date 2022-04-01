package warehouse.inneroperationscore.controllers;

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
        return nomenclatureService.insert(nomenclatureEntity);
    }

    @GetMapping("/{id}")
    public NomenclatureDto findNomenclatureById(@PathVariable Long id) {
        System.out.println(nomenclatureService.findById(id));
        return modelMapper.map(nomenclatureService.findById(id), NomenclatureDto.class);
    }

    @DeleteMapping("/{id}")
    public boolean deleteNomenclatureById(@PathVariable Long id) {
        return nomenclatureService.deleteById(id);
    }
}
