package racingcar.enums;

public enum ErrorMessageTemplate {
    INVALID_EMPTY_INPUT("빈 문자열의 입력이 감지됐습니다! 1이상의 문자열을 입력해주세요");

    private final String message;

    ErrorMessageTemplate(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
