package racingcar.controller;

import racingcar.service.ExtractCarNameService;
import racingcar.service.InputService;
import racingcar.service.RacingService;
import racingcar.util.RandomNumberGenerator;

import java.util.List;

public class MainController {
    private final InputService inputService;
    private final ExtractCarNameService extractCarNameService;
    private final RacingService racingService;
    private final RandomNumberGenerator randomNumberGenerator;

    public MainController(InputService inputService, ExtractCarNameService extractCarNameService, RacingService racingService, RandomNumberGenerator randomNumberGenerator) {
        this.inputService = inputService;
        this.extractCarNameService = extractCarNameService;
        this.racingService = racingService;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void runApp() {
        ExtractController extractController = new ExtractController(inputService, extractCarNameService);
        RacingController racingController = new RacingController(inputService, racingService, randomNumberGenerator);

        List<String> carNameList = extractController.runExtract();
        racingController.runRacingCar(carNameList);
    }
}
