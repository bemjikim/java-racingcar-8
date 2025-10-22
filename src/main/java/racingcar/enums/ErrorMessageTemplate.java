package racingcar.enums;

public enum ErrorMessageTemplate {
    INVALID_EMPTY_INPUT("빈 문자열의 입력이 감지됐습니다! 길이가 1 이상의 입력을 입력해주세요."),
    INVALID_CAR_NAME_FORMAT("자동차 이름은 알파벳, 숫자, 한글을 제외한 문자를 허용하지 않습니다."),
    INVALID_DELIMITER_FORMAT("',' 구분자의 형식이 잘못 됐습니다. ex) a, b, c"),
    INVALID_OVER_CAR_NAME_LENGTH("각 자동차의 이름의 길이는 5이하로 제한됩니다! 입력한 이름과 길이: "),
    INVALID_DUPLICATE_CAR_NAME("각 자동차의 이름은 중복될 수 없습니다: ");

    private final String message;

    ErrorMessageTemplate(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
