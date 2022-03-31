package warehouse.inneroperationscore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    private Long id;

    private String productType;

    private String name;

    private Integer price;

    private Long count;

}
