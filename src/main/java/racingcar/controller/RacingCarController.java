package racingcar.controller;

import static racingcar.constants.NumberConstants.INDEX_NUMBER;

import java.util.List;
import racingcar.domain.Car;
import racingcar.io.InputView;
import racingcar.io.OutputView;
import racingcar.io.parser.InputParser;
import racingcar.io.parser.ResultParser;
import racingcar.service.RacingCarService;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    private final InputParser inputParser;
    private final ResultParser resultParser;

    private final RacingCarService service;


    public RacingCarController(InputView inputView, OutputView outputView,
                               InputParser inputParser, ResultParser resultParser,
                               RacingCarService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
        this.resultParser = resultParser;
        this.service = service;
    }

    public void run() {
        List<String> carNames = getValidCarNames();
        int tryCount = getValidTryCount();

        List<Car> cars = service.race(carNames, tryCount);

        printResult(tryCount, cars);
    }

    private List<String> getValidCarNames() {
        String input = inputView.readCarNames();
        return inputParser.parseCarNames(input);
    }

    private int getValidTryCount() {
        String input = inputView.readTryCount();
        return inputParser.parseTryCount(input);
    }

    private void printResult(int tryCount, List<Car> cars) {
        printOneRoundResult(tryCount, cars);
        printTotalResult(cars);
    }

    private void printOneRoundResult(int tryCount, List<Car> cars) {
        outputView.printResultMessage();
        for (int round = 0; round < tryCount; round++) {
            String oneRoundResult = resultParser.parseOneRoundResult(cars, round + INDEX_NUMBER);
            outputView.printOneRoundResult(oneRoundResult);
        }
    }

    private void printTotalResult(List<Car> cars) {
        List<String> winners = service.getWinner(cars);
        String totalResult = resultParser.parseRaceResult(winners);
        outputView.printRaceResult(totalResult);
    }

}
