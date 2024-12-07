package racingcar.service;

import static racingcar.constants.NumberConstants.INDEX_NUMBER;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarManager;

public class RacingCarService {

    // 경주 시작
    public List<Car> race(List<String> carNames, int tryCount) {
        List<Car> cars = getAllCars(carNames);
        for (int round = 0; round < tryCount; round++) { // 시도 횟수만큼 경주
            processOneRound(cars, round + INDEX_NUMBER);
        }
        return cars;
    }

    private List<Car> getAllCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>(); // 경주에 참여한 자동차들
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void processOneRound(List<Car> cars, int round) {
        for (Car car : cars) {
            boolean isMoveCondition = new CarManager().isMoveCondition();
            car.moveOrNot(isMoveCondition, round);
        }
    }

    // 우승자 결정
    public List<String> getWinner(List<Car> cars) {
        int maxScore = getMaxScore(cars);

        return cars.stream()
                .filter(car -> car.getTotalScore() == maxScore)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int getMaxScore(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getTotalScore)
                .max()
                .orElse(0);
    }
}
