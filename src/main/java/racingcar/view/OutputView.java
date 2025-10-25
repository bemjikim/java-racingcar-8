package racingcar.view;

import racingcar.enums.UITemplate;

public class OutputView {
    public static void printResultOutputUI() {
        System.out.println(UITemplate.RESULT_OUTPUT_MESSAGE.getMessage());
    }

    public static void printWinnerOutputUI() {
        System.out.print(UITemplate.WINNER_OUTPUT_MESSAGE.getMessage());
    }
}
