package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class InputService {
    public String readNameInput() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public String readTryInput() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}
