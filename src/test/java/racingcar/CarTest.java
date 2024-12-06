package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    @Test
    void 자동차는_전진할_수_있다() {
        //given
        Car car = new Car("포비");
        int randomNum = pickNumberInRange(0, 9);

        //when
        if (randomNum > 4) {
            car.go();
        }

        int actualScore = car.getScore();

        //then
        Assertions.assertThat(actualScore).isEqualTo(1);
    }
}
