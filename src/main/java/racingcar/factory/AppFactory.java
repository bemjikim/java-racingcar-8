package racingcar.factory;

import racingcar.controller.MainController;
import racingcar.service.ExtractCarNameService;
import racingcar.service.InputService;
import racingcar.service.RacingService;


public class AppFactory {
    private final InputService inputService;
    private final ExtractCarNameService extractCarNameService;
    private final RacingService racingService;

    public AppFactory() {
        this.inputService = new InputService();
        this.extractCarNameService = new ExtractCarNameService();
        this.racingService = new RacingService();
    }

    public MainController settingMainController() {
        return new MainController(inputService, extractCarNameService, racingService);
    }
}

