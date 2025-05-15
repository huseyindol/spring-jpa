package com.jpatutorial.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {
    private List<String> addMapValue(List<String> list, String newValue) {
        list.add(newValue);
        return list;
    }

    //    Spring validation'dan fırlatılan hataları yönetmek
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, List<String>> errMap = new HashMap<>();
        for (ObjectError objErr : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) objErr).getField();
            if (errMap.containsKey(fieldName)) {
                errMap.put(fieldName,addMapValue(errMap.get(fieldName),objErr.getDefaultMessage()));
            } else {
                errMap.put(fieldName, addMapValue(new ArrayList<>(), objErr.getDefaultMessage()));
            }
        }

        return ResponseEntity.badRequest().body(createApiError(errMap));
    }

    private <T> ApiError<T> createApiError(T errors){
        ApiError<T> apiError = new ApiError<>();
        apiError.setId(UUID.randomUUID().toString());
        apiError.setErrorTime(new Date());
        apiError.setErrors(errors);

        return apiError;
    }
}
