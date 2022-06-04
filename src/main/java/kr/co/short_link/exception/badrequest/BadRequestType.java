package kr.co.short_link.exception.badrequest;

public enum BadRequestType {

    DEFAULT("잘못된 요청 데이터 입니다.")
    ;

    private final String message;

    BadRequestType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
