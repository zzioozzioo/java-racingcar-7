package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class RacingCarService {


    public List<Car> race(List<String> carNames) {
        List<Car> cars = new ArrayList<>(); // 경주에 참여한 자동차들
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        for (Car car : cars) {
            if (pickNumberInRange(0, 9) > 4) {
                car.go();
            }
        }
        return cars;
    }
}
