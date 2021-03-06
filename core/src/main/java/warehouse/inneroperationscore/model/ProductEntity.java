package warehouse.inneroperationscore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends AbstractEntity{

    private Long nomenclatureId;

    private Double price;

    private Long count;

}
