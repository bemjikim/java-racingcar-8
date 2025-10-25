package racingcar.controller;

import racingcar.service.InputService;
import racingcar.service.RacingService;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.util.Validator.*;

public class RacingController {
    private final InputService inputService;
    private final RacingService racingService;

    public RacingController(InputService inputService, RacingService racingService) {
        this.inputService = inputService;
        this.racingService = racingService;
    }

    public void runRacingCar(List<String> carNameList) {
        String tryInput = inputService.readTryInput();
        tryValidation(tryInput);

        racingService.setupCarNameList(carNameList);

        OutputView.printResultOutputUI();
        for(int i = 0; i < Integer.parseInt(tryInput); i++) {
            racingService.roundStart();
        }

        List<String> winnerList = racingService.findWinner();

        OutputView.printWinnerOutputUI();
        System.out.println(String.join(", ", winnerList));
    }


    private void tryValidation(String tryInput) {
        validateEmptyInput(tryInput);
        validateTryInput(tryInput);
    }
}
