package racingcar.factory;

import racingcar.controller.RacingCarController;
import racingcar.service.DelimiterService;
import racingcar.service.InputService;
import racingcar.service.RacingService;

public class AppFactory {
    private final InputService inputService;
    private final DelimiterService delimiterService;
    private final RacingService racingService;

    public AppFactory() {
        this.inputService = new InputService();
        this.delimiterService = new DelimiterService();
        this.racingService = new RacingService();
    }

    public RacingCarController settingRacingCarController() {
        return new RacingCarController(inputService, delimiterService, racingService);
    }
}
