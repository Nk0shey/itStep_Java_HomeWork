package com.nk0shey.productservice;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.dao.DataIntegrityViolationException;
import java.util.Map;
@RestControllerAdvice
public class ApiErrors {
 @ExceptionHandler(MethodArgumentNotValidException.class)
 ResponseEntity<?> validation(MethodArgumentNotValidException e) {
  return ResponseEntity.badRequest().body(Map.of("error", "Invalid request", "details",
   e.getBindingResult().getFieldErrors().stream().map(f -> f.getField()+": "+f.getDefaultMessage()).toList()));
 }
 @ExceptionHandler(DataIntegrityViolationException.class)
 ResponseEntity<?> conflict() {return ResponseEntity.status(409).body(Map.of("error","Conflicting request; retry with the same idempotency key"));}
}
