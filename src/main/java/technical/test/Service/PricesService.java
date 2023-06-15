package technical.test.Service;

import java.time.LocalDateTime;
import java.util.Map;

public interface PricesService {
    public Map getPrice(LocalDateTime filter_date,Integer product_id, Integer brand_id) throws Exception ;    
}
