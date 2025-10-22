package racingcar.view;

import racingcar.enums.UITemplate;

public class InputView {
    public void printNameInputUI() {
        System.out.println(UITemplate.NAME_INPUT_MESSAGE.getMessage());
    }

    public void printTryInputUI() {
        System.out.println(UITemplate.TRY_INPUT_MESSAGE.getMessage());
    }
}
