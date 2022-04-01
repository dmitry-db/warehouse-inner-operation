package warehouse.inneroperationscore.service.interfaces;

import warehouse.inneroperations.ProductDto;

public interface SaleService {

    boolean saleProductByNomenclatureId(ProductDto productDto);
}
