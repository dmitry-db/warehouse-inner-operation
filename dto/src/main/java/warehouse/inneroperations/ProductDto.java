package warehouse.inneroperations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;

    private Long nomenclatureId;

    private String productType;

    private String productName;

    private Double price;

    private Long count;
}
