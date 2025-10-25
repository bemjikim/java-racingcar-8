package racingcar.view;

import racingcar.enums.UITemplate;

public class InputView {
    public static void printNameInputUI() {
        System.out.println(UITemplate.NAME_INPUT_MESSAGE.getMessage());
    }

    public static void printTryInputUI() {
        System.out.println(UITemplate.TRY_INPUT_MESSAGE.getMessage());
    }
}
