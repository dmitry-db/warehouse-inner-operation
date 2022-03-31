package warehouse.inneroperationscore.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {

    private Long id;

    private Long typeId;

    private String name;

    private Double price;

    public Product(Long typeId, String name, Double price) {
        this.typeId = typeId;
        this.name = name;
        this.price = price;
    }
}
