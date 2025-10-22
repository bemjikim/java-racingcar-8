package racingcar.controller;

import racingcar.service.InputService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputService inputService;

    public RacingCarController(InputView inputView, OutputView outputView, InputService inputService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputService = inputService;
    }

    public void runRacingCar() {
        inputView.printNameInputUI();
        String user_name_input = inputService.readNameInput();
        String user_try_input = inputService.readTryInput();

        outputView.printResultOutputUI();
        outputView.printWinnerOutputUI();
    }
}
