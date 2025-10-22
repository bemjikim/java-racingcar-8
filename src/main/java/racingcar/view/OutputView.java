package racingcar.view;

import racingcar.enums.UITemplate;

public class OutputView {
    public void printResultOutputUI() {
        System.out.println(UITemplate.RESULT_OUTPUT_MESSAGE.getMessage());
    }

    public void printWinnerOutputUI() {
        System.out.print(UITemplate.WINNER_OUTPUT_MESSAGE.getMessage());
    }
}
