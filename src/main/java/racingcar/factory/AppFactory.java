package racingcar.factory;

import racingcar.controller.MainController;
import racingcar.service.ExtractCarNameService;
import racingcar.service.InputService;
import racingcar.service.RacingService;
import racingcar.util.RandomNumberGenerator;


public class AppFactory {
    private final InputService inputService;
    private final ExtractCarNameService extractCarNameService;
    private final RacingService racingService;
    private final RandomNumberGenerator randomNumberGenerator;

    public AppFactory() {
        this.inputService = new InputService();
        this.extractCarNameService = new ExtractCarNameService();
        this.racingService = new RacingService();
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public MainController settingMainController() {
        return new MainController(inputService, extractCarNameService, racingService, randomNumberGenerator);
    }
}

