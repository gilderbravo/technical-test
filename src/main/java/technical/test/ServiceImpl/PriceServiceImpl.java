package technical.test.ServiceImpl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import technical.test.Repository.PricesRepository;
import technical.test.Service.PricesService;

@Service
public class PriceServiceImpl implements PricesService {
    @Autowired
    PricesRepository pricesRepository;
    @Override
    public Map getPrice(LocalDateTime filter_date, Integer product_id, Integer brand_id) throws Exception {
        try {
			
			Map response= new HashMap(); 
            response = pricesRepository.findAllByDateProductBrand(filter_date,product_id,brand_id);                     
            return response;
		} catch (Exception e) {
			throw new Exception("Error: getPrices:_s:"+e.getMessage());
		}
    }
}
