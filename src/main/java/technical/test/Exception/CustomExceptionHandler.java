package technical.test.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        String errorMessage = "El parámetro: " + ex.getName() + " debe ser del tipo " + ex.getRequiredType().getSimpleName();
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", errorMessage);

        return ResponseEntity.badRequest().body(errorResponse);
    }
   
}