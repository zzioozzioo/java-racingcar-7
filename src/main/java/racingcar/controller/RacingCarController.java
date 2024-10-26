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

    RacingCarService service = new RacingCarService();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {

        String inputCarNames = getInputCarNames();
        int inputCount = getInputCount();

        List<String> splitCarNames = getSplitCarNames(inputCarNames);
        race(splitCarNames, inputCount);
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

    private void race(List<String> splitCarNames, int inputCount) {
        Map<String, Integer> cars = service.getNewCars(splitCarNames);
        raceAllRound(inputCount, cars);
        printWinners(cars);
    }

    private void raceAllRound(int inputCount, Map<String, Integer> cars) {
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
