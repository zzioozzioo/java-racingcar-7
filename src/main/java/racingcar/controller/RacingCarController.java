package racingcar.controller;

import static racingcar.util.Utility.getSplitCarNames;
import static racingcar.validator.Validator.validateInputCarNamesContainComma;
import static racingcar.validator.Validator.validateInputCountRange;

import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    // TODO: 의존성 주입 고민해보기

    private final OutputView outputView;
    private final RacingCarService service;
    private final InputView inputView;

    public RacingCarController(RacingCarService service, InputView inputView, OutputView outputView) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

        String inputCarNames = getInputCarNames();
        int inputCount = getInputCount();

        List<String> splitCarNames = getSplitCarNames(inputCarNames);

        Map<String, Integer> cars = service.getNewCars(splitCarNames);
        race(inputCount, cars);
        printWinners(cars);
    }

    private String getInputCarNames() {
        String inputCarNames = inputView.readCarNames();
        validateInputCarNamesContainComma(inputCarNames);
        return inputCarNames;
    }

    private int getInputCount() {
        int inputCount = inputView.readTryCount();
        validateInputCountRange(inputCount);
        return inputCount;
    }

    private void race(int inputCount, Map<String, Integer> cars) {
        for (int count = 0; count < inputCount; count++) {
            service.raceOneRound();
            outputView.printOneRoundResult(cars);
        }
    }

    private void printWinners(Map<String, Integer> cars) {
        service.getMaxPosition(cars);
        Set<String> winningCars = service.getWinningCars(cars);
        outputView.printWinningCars(winningCars);
    }
}
