package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.RacingCars;
import racingcar.domain.Winning;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RacingCars racingCars = new RacingCars();
        Winning winning = new Winning();

        RacingCarService service = new RacingCarService(racingCars, winning);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        RacingCarController controller = new RacingCarController(service, inputView, outputView);
        controller.run();
    }
}