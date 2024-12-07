package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"false, 0", "true, 1"})
    void 자동차는_전진할_수_있다(boolean isMoveCondition, int expectedScore) {
        //given
        Car car = new Car("포비");
        int round = 1;

        //when
        car.moveOrNot(isMoveCondition, round);
        int actualScore = car.getRoundScore().get(round);

        //then
        Assertions.assertThat(actualScore).isEqualTo(expectedScore);
    }
}
