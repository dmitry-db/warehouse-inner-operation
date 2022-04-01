package warehouse.inneroperationscore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NomenclatureEntity extends AbstractEntity{

    private String productType;

    private String productName;
}
