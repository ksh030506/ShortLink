package kr.co.ab180.exception;

import kr.co.ab180.domain.CommonResult;
import kr.co.ab180.exception.badrequest.BadRequestException;
import kr.co.ab180.exception.datanotfound.DataNotFoundException;
import kr.co.ab180.service.ResponseService;
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
