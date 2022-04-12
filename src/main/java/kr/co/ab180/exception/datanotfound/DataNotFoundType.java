package kr.co.ab180.exception.datanotfound;

public enum DataNotFoundType {

    DEFAULT("필수")
    ;


    private final String message;

    DataNotFoundType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message.concat(" 데이터가 존재하지 않습니다.");
    }

    public String message(){
        return message;
    }
}
