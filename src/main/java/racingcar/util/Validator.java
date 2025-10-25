package racingcar.util;

import racingcar.enums.ErrorMessageTemplate;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final int Limited_Name_Length = 5;
    private static final String REGEXP_EXCEPT_CHAR_NUM = "[^a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]";

    public static void validateEmptyInput(String user_input){
        if (user_input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessageTemplate.INVALID_EMPTY_INPUT.getMessage());
        }
    }

    public static void validateTryInput(String tryInput) {
        try {
            int tryNumber = Integer.parseInt(tryInput);

            if (tryNumber <= 0) {
                throw new IllegalArgumentException(ErrorMessageTemplate.INVALID_SMALLER_THAN_ZERO.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageTemplate.INVALID_NONE_NUMBER.getMessage());
        }
    }

    public static void validateCarName(List<String> carNameList) {
        carNameList.forEach(carName -> {
            validateCarNameFormat(carName);
            validateDelimiterFormat(carName);
            validateCarNameLength(carName);
        });

        validateCarNameIsDuplicate(carNameList);
    }

    private static void validateCarNameFormat(String carName) {
        Pattern pattern = Pattern.compile(REGEXP_EXCEPT_CHAR_NUM);
        Matcher matcher = pattern.matcher(carName);

        if (matcher.find()) {
            throw new IllegalArgumentException(ErrorMessageTemplate.INVALID_CAR_NAME_FORMAT.getMessage());
        }
    }

    private static void validateDelimiterFormat(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessageTemplate.INVALID_DELIMITER_FORMAT.getMessage());
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > Limited_Name_Length) {
            throw new IllegalArgumentException(ErrorMessageTemplate.INVALID_OVER_CAR_NAME_LENGTH.getMessage() + carName + " " + carName.length());
        }
    }

    private static void validateCarNameIsDuplicate(List<String> carNameList) {
        if (carNameList.size() != carNameList.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessageTemplate.INVALID_DUPLICATE_CAR_NAME.getMessage());
        }
    }
}
