package racingcar.controller;

import racingcar.service.ExtractCarNameService;
import racingcar.service.InputService;

import java.util.List;

import static racingcar.util.Validator.validateCarName;
import static racingcar.util.Validator.validateEmptyInput;

public class ExtractController {
    private final InputService inputService;
    private final ExtractCarNameService extractCarNameService;

    public ExtractController(InputService inputService, ExtractCarNameService extractCarNameService) {
        this.inputService = inputService;
        this.extractCarNameService = extractCarNameService;
    }

    public List<String> runExtract() {
        String carNameInput = inputService.readCarNameInput();
        List<String> carNameList = extractCarNameService.extractCarName(carNameInput);
        carNameValidation(carNameInput, carNameList);

        return carNameList;
    }

    private void carNameValidation(String carNameInput, List<String> carNameList) {
        validateEmptyInput(carNameInput);
        validateCarName(carNameList);
    }
}
