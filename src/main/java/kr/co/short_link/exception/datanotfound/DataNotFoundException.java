package kr.co.short_link.exception.datanotfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException() {
        super(DataNotFoundType.DEFAULT.getMessage());
    }

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(DataNotFoundType dataType) {
        super(dataType.getMessage());
    }

}
