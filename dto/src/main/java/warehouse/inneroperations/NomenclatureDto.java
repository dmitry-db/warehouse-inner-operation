package warehouse.inneroperations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NomenclatureDto {

    private Long id;

    private String productType;

    private String productName;
}
