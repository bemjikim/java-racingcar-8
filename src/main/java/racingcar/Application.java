package racingcar;

import racingcar.controller.MainController;
import racingcar.controller.RacingController;
import racingcar.factory.AppFactory;

public class Application {
    public static void main(String[] args) {
        AppFactory appFactory = new AppFactory();

        MainController mainController = appFactory.settingMainController();
        mainController.runApp();
    }
}
