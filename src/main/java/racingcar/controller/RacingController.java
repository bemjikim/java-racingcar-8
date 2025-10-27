package racingcar.controller;

import racingcar.service.InputService;
import racingcar.service.RacingService;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.util.Validator.*;

public class RacingController {
    private final InputService inputService;
    private final RacingService racingService;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingController(InputService inputService, RacingService racingService, RandomNumberGenerator randomNumberGenerator) {
        this.inputService = inputService;
        this.racingService = racingService;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void runRacingCar(List<String> carNameList) {
        String tryInput = inputService.readTryInput().trim();
        tryValidation(tryInput);

        racingService.setupCarNameList(carNameList);

        OutputView.printResultOutputUI();
        for(int i = 0; i < Integer.parseInt(tryInput); i++) {
            racingService.roundStart(randomNumberGenerator);
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
