package technical.test.Repository;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import technical.test.Entity.Prices;

public interface PricesRepository extends JpaRepository<Prices, Integer>{
    @Query (value="SELECT PRODUCT_ID,BRAND_ID,PRICE_LIST,START_DATE,END_DATE,PRICE FROM PRICES WHERE PRODUCT_ID =:product_id  and BRAND_ID =:brand_id and START_DATE <= :filter_date AND END_DATE>= :filter_date ORDER BY PRIORITY DESC LIMIT 1 ", nativeQuery=true)
	public Map findAllByDateProductBrand(@Param("filter_date") LocalDateTime filter_date,@Param("product_id") Integer product_id,@Param("brand_id") Integer brand_id);


}
