package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.factory.AppFactory;

public class Application {
    public static void main(String[] args) {
        AppFactory appFactory = new AppFactory();

        RacingCarController racingCarController = appFactory.settingRacingCarController();
        racingCarController.runRacingCar();
    }
}
