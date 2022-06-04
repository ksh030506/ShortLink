package kr.co.short_link.exception;

import kr.co.short_link.domain.CommonResult;
import kr.co.short_link.exception.badrequest.BadRequestException;
import kr.co.short_link.exception.datanotfound.DataNotFoundException;
import kr.co.short_link.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

    private final ResponseService responseService;

    @ExceptionHandler(DataNotFoundException.class)
    protected CommonResult DataNotFoundException(DataNotFoundException e) {
        return responseService.getFailResult(-1, e.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    protected CommonResult BadRequestException(BadRequestException e) {
        return responseService.getFailResult(-1, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult processValidationError(MethodArgumentNotValidException e) {
        return responseService.getFailResult(-1, e.getAllErrors().get(0).getDefaultMessage());
    }
}
