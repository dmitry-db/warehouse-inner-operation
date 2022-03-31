package warehouse.inneroperationscore.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TypeProduct {

    private Long id;

    private String name;

    public TypeProduct(String name) {
        this.name = name;
    }
}
