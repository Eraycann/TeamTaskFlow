package com.kafka.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.kafka.exception.BaseException;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.time.LocalDateTime; // Eksik import tamamlandı.

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiError<?>> handleBaseException(BaseException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(createApiError(ex.getMessage(), request));
    }
    
    public String getHostName() {
    	try {
			return Inet4Address.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			System.err.println("Host adı alınamadı. Hata: " + e.getMessage());
			return "Unknown Host";
		}
    }

    public <E> ApiError<E> createApiError(E message, WebRequest request) {
        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        Exception<E> exception = new Exception<>();
        exception.setPath(request.getDescription(false).substring(4));
        exception.setCreateTime(LocalDateTime.now());
        exception.setMessage(message);
        exception.setHostName(getHostName());
        
        apiError.setException(exception);
        return apiError;
    }
}
