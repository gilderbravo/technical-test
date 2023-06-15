package technical.test.Controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import technical.test.Service.PricesService;

@RequestMapping("/api/prices")
@RestController
@ControllerAdvice(annotations = RestController.class)
public class PricesController {
    @Autowired
    PricesService pricesService;
    @GetMapping()
	public ResponseEntity<Map>getPrice(@RequestParam("filter_date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime filter_date,
			@RequestParam(name = "product_id",required = true) Integer product_id,
            @RequestParam(name = "brand_id",required = true) Integer brand_id ) throws Exception {
		try {  
             if (!isValid(filter_date) || !isValid(product_id) || !isValid(brand_id)) {
                throw new MethodArgumentTypeMismatchException(null, null, null, null, null);
            }          
			Map response=pricesService.getPrice(filter_date,product_id,brand_id);
		    return ResponseEntity.ok(response); 
		} catch (MethodArgumentTypeMismatchException e) {
            throw e;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
    private boolean isValid(Object param) {
        return param != null;
    }
}
