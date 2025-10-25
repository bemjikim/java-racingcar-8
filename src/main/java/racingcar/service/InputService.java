package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;

import java.util.NoSuchElementException;

public class InputService {
    public String readCarNameInput() {
        InputView.printNameInputUI();

        return readInput();
    }

    public String readTryInput() {
        InputView.printTryInputUI();

        return readInput();
    }

    private String readInput() {
        String userInput;

        try {
            userInput = Console.readLine();
        } catch (NoSuchElementException e) {
            userInput = "";
        }

        return userInput;
    }
}
