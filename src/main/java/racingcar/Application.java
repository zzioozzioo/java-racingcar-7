package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig config = new AppConfig();
        RacingCarController controller = new RacingCarController(
                config.getInputView(),
                config.getOutputView(),
                config.getInputParser(),
                config.getResultParser(),
                config.getService()
        );
        controller.run();
    }
}
