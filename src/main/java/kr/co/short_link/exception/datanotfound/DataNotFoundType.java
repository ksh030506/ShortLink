package kr.co.short_link.exception.datanotfound;

public enum DataNotFoundType {

    DEFAULT("필수"),
    NOT_FOUND_LINK("해당하는 Link를 찾을 수 없습니다.")
    ;

    private final String message;

    DataNotFoundType(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
