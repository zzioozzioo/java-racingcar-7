package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    @Test
    void 자동차는_전진할_수_있다() {
        //given
        Car car = new Car("포비");
//        int randomNum = pickNumberInRange(0, 9);
        int randomNum = 5;
        int round = 1;

        //when
        if (randomNum > 4) {
            car.move(round); // 1라운드
        } else {
            car.notMove(round);
        }

        int actualScore = car.getRoundScore().get(round);

        //then
        Assertions.assertThat(actualScore).isEqualTo(1);
    }
}
