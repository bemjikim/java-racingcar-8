package racingcar.service;

import racingcar.dto.CarList;
import racingcar.enums.ErrorMessageTemplate;
import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    private List<CarList> carInfoList;
    private static final String MOVING_MARK = "-";

    public void setupCarNameList(List<String> carNameList){
        carInfoList = new ArrayList<>();

        for (String name:  carNameList){
            carInfoList.add(registCarName(name, 0));
        }
    }

    public CarList registCarName(String name, int moveCount) {
        return new CarList(name, moveCount);
    }

    public void roundStart(RandomNumberGenerator generator) {
        for(CarList carList : carInfoList) {
            int randomNumber = generator.generate();

            carList.checkMoveForward(randomNumber);
            roundBroadcasting(carList);
        }
        System.out.println();
    }

    public void roundBroadcasting(CarList carList) {
        System.out.println(carList.getName() + " : " + MOVING_MARK.repeat(carList.getMoveCount()));
    }

    public List<String> findWinner() {
        int maxMoveCount = carInfoList.stream()
                                      .mapToInt(CarList::getMoveCount)
                                      .max()
                                      .orElseThrow(() -> new IllegalArgumentException(ErrorMessageTemplate.NONE_FOUND_MAX_VALUE.getMessage()));

        List<String> winnerList = carInfoList.stream()
                                             .filter(CarList -> CarList.getMoveCount() == maxMoveCount)
                                             .map(CarList::getName)
                                             .toList();

        return winnerList;
    }
}
