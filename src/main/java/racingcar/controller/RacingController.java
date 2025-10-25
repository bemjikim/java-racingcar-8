package racingcar.controller;

import racingcar.service.ExtractCarNameService;
import racingcar.service.InputService;
import racingcar.service.RacingService;

import java.util.List;

import static racingcar.util.Validator.*;

public class RacingCarController {
    private final InputService inputService;
    private final ExtractCarNameService extractCarNameService;
    private final RacingService racingService;

    // TODO: 도메인 패키지 구조로 하자~
    public RacingCarController(InputService inputService, ExtractCarNameService extractCarNameService, RacingService racingService) {
        this.inputService = inputService;
        this.extractCarNameService = extractCarNameService;
        this.racingService = racingService;
    }

    public void runRacingCar() {
        String carNameInput = inputService.readCarNameInput();
        String tryInput = inputService.readTryInput();

        List<String> carNameList = extractCarNameService.extractCarName(carNameInput);

        carNameValidation(carNameInput, carNameList);
        tryValidation(tryInput);

        racingService.setupCarNameList(carNameList);
        racingService.getCarInfoList();



    }


    private void carNameValidation(String carNameInput, List<String> carNameList) {
        validateEmptyInput(carNameInput);
        validateCarName(carNameList);
    }

    private void tryValidation(String tryInput) {
        validateTryInput(tryInput);
    }
}
