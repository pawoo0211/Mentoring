package com.example.mentoring.exception;

import com.example.mentoring.exception.domain.CheckOpeningException;
import com.example.mentoring.exception.domain.MenuNotFoundException;
import com.example.mentoring.exception.domain.MerchantNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResponseDto invalidRequestExceptionHandler(MethodArgumentNotValidException e) {
        log.error("[invalidRequestExceptionHandler]: {}", e);

        // "@Valid"에 맞지 않을 때 예외 처리
        ExceptionResponseDto exceptionResponseDto = ExceptionResponseDto.builder()
                .isSuccess(false)
                .errorMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage())
                .build();

        return exceptionResponseDto;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ExceptionResponseDto MenuNotFoundExceptionHandler(MenuNotFoundException e) {
        log.error("[MenuNotFoundExceptionHandler]= {}", e);

        // Menu Not Found 예외 처리
        ExceptionResponseDto exceptionResponseDto = ExceptionResponseDto.builder()
                .isSuccess(false)
                .errorMessage("해당 메뉴는 존재하지 않습니다.")
                .build();

        return exceptionResponseDto;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ExceptionResponseDto MerchantNotFoundExceptionHandler(MerchantNotFoundException e) {
        log.error("[MerchantNotFoundExceptionHandler]= {}", e);

        ExceptionResponseDto exceptionResponseDto = ExceptionResponseDto.builder()
                .isSuccess(false)
                .errorMessage("해당 가맹점은 존재하지 않습니다.")
                .build();

        return exceptionResponseDto;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ExceptionResponseDto CheckOpeningExceptionHandler(CheckOpeningException e) {
        log.error("[CheckOpeningExceptionHandler]= {}", e);

        ExceptionResponseDto exceptionResponseDto = ExceptionResponseDto.builder()
                .isSuccess(false)
                .errorMessage("현재 주문 가능한 시간이 아닙니다.")
                .build();

        return exceptionResponseDto;
    }
}
