package com.example.mentoring.exception;

import com.example.mentoring.exception.domain.MenuNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ExceptionResponseDto MenuNotFoundExceptionHandler(MenuNotFoundException e){
        log.error("[MenuNotFoundExceptionHandler]= {}",e);

        // Post Not Found 예외 처리
        ExceptionResponseDto exceptionResponseDto = ExceptionResponseDto.builder()
                .isSuccess(false)
                .errorMessage("해당 메뉴는 존재하지 않습니다.")
                .build();

        return exceptionResponseDto;
    }
}
