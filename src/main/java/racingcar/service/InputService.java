package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;

import java.util.NoSuchElementException;

import static racingcar.util.Validator.validateEmptyInput;

public class InputService {
    public String readNameInput() {
        InputView.printNameInputUI();

        return checkEmptyInput();
    }

    public String readTryInput() {
        InputView.printTryInputUI();

        return checkEmptyInput();
    }

    private String checkEmptyInput() {
        String user_input;

        try {
            user_input = Console.readLine();
        } catch (NoSuchElementException e) {
            user_input = "";
        }
        validateEmptyInput(user_input);

        return user_input;
    }
}
