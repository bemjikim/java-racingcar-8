package racingcar.controller;

import racingcar.service.ExtractCarNameService;
import racingcar.service.InputService;
import racingcar.service.RacingService;

import java.util.List;

public class MainController {
    private final InputService inputService;
    private final ExtractCarNameService extractCarNameService;
    private final RacingService racingService;

    public MainController(InputService inputService, ExtractCarNameService extractCarNameService, RacingService racingService) {
        this.inputService = inputService;
        this.extractCarNameService = extractCarNameService;
        this.racingService = racingService;
    }

    public void runApp() {
        ExtractController extractController = new ExtractController(inputService, extractCarNameService);
        RacingController racingController = new RacingController(inputService, racingService);

        List<String> carNameList = extractController.runExtract();
        racingController.runRacingCar(carNameList);
    }
}
