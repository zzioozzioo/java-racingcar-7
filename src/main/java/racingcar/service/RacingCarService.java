package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.constants.NumberConstants.INDEX_NUMBER;
import static racingcar.constants.NumberConstants.MAXIMUM_RANDOM_NUMBER;
import static racingcar.constants.NumberConstants.MINIMUM_RANDOM_NUMBER;
import static racingcar.constants.NumberConstants.MOVE_CONDITION_NUMBER;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

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
            moveOrNot(car, round);
        }
    }

    private void moveOrNot(Car car, int round) {
        if (pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER)
                >= MOVE_CONDITION_NUMBER) { // TODO: 다른 클래스에 위임하기
            car.move(round);
            return;
        }
        car.notMove(round);
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
