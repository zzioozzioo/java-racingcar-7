package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class RacingCarService {

    public List<Car> race(List<String> carNames, int tryCount) {
        List<Car> cars = getAllCars(carNames);
        for (int round = 1; round < tryCount + 1; round++) { // 시도 횟수만큼 경주
            processOneRound(cars, round);
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
        if (pickNumberInRange(0, 9) > 4) { // TODO: 다른 클래스에 위임하기
            car.move(round);
            return;
        }
        car.notMove(round);
    }
}
