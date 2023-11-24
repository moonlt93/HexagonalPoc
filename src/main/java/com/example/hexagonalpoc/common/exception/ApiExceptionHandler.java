package com.example.hexagonalpoc.common.exception;



import com.example.hexagonalpoc.common.exception.exceptions.AppException;
import com.example.hexagonalpoc.common.exception.exceptions.CustomConstraintViolationException;
import com.example.hexagonalpoc.common.response.ErrorResponse;
import com.example.hexagonalpoc.common.response.ResponseBuilder;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestController
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationExceptions(CustomConstraintViolationException exception) {
        String errorDescription = "";
        errorDescription = getErrorDescription(exception);

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .errorDescription(errorDescription)
                .build();

        return ResponseBuilder.build(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /*
    @Valid 적용 후 Command로 들어가는 매개변수 value 에 대해 ConstraintViolationException 발생
    이를 처리하기 위해 Exception 추가
    * */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationExceptions(ConstraintViolationException exception) {
        String errorDescription = "";
        errorDescription = getErrorDescription(exception);

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .errorDescription(errorDescription)
                .build();

        return ResponseBuilder.build(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /*
    TODO: 에러 메시지 구분을 위한 Exception 분리 고려
    * */

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(ex.getStatusCode().toString())
                .errorDescription(ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage())
                .build();

        return ResponseBuilder.build(errorResponse, HttpStatus.resolve(status.value()));
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<Object> handleAppException(AppException exception) {
        ExceptionInfo exceptionInfo = exception.getExceptionInfo();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(exceptionInfo.getCode())
                .errorDescription(exceptionInfo.getMessage())
                .build();

        return ResponseBuilder.build(errorResponse, exceptionInfo.getHttpStatus());
    }
    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<Object> handleAppException(PersistenceException exception) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .errorDescription("조회된 엔티티가 없습니다."+exception.getLocalizedMessage())
                .build();

        return ResponseBuilder.build(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(RuntimeException exception) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .errorDescription(exception.getMessage())
                .build();

        return ResponseBuilder.build(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
    mockMvc test 에러메시지 구분을 위한 분할
    * */
    private static String getErrorDescription(ValidationException exception) {
        return StringUtils.isEmpty(exception.getLocalizedMessage())
                ? HttpStatus.BAD_REQUEST.name()
                : exception.getLocalizedMessage();
    }
}
