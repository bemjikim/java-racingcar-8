package racingcar.controller;

import racingcar.service.DelimiterService;
import racingcar.service.InputService;
import racingcar.service.RacingService;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    private final InputService inputService;
    private final DelimiterService delimiterService;
    private final RacingService racingService;


    public RacingCarController(InputService inputService, DelimiterService delimiterService, RacingService racingService ) {
        this.inputService = inputService;
        this.delimiterService = delimiterService;
        this.racingService = racingService;
    }

    public void runRacingCar() {
        List<String> carNameList = getNameListWithSplit();
        List<String> winnerList = getTryResultWithRacing();

        // TODO: Print Result
    }

    private List<String> getNameListWithSplit() {
        String user_name_input = inputService.readNameInput();

        return delimiterService.splitDelimiter(user_name_input);
    }

    private List<String> getTryResultWithRacing() {
        String user_try_input = inputService.readTryInput();

        // TODO: Return winner List
        return new ArrayList<>();
    }
}
