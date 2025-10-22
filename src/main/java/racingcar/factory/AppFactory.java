package racingcar.factory;

import racingcar.controller.RacingCarController;
import racingcar.service.InputService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppFactory {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputService inputService;

    public AppFactory() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputService = new InputService();
    }

    public RacingCarController settingRacingCarController() {
        return new RacingCarController(inputView, outputView, inputService);
    }
}
