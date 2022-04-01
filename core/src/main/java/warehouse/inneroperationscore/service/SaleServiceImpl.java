package warehouse.inneroperationscore.service;

import org.springframework.stereotype.Service;
import warehouse.inneroperationscore.repository.SaleRepository;
import warehouse.inneroperationscore.service.interfaces.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public boolean saleProduct(String name, Long count) {
        return saleRepository.saleProduct(name, count);
    }
}
