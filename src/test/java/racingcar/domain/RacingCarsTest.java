package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @ParameterizedTest
    @ValueSource(strings = {"abc", "def"})
    void 자동차_초기화_테스트(String carName) {
        //given
        List<String> splitCarName = List.of("abc", "def");
        RacingCars racingCars = new RacingCars();

        //when
        Map<String, Integer> cars = racingCars.initializeCars(splitCarName);

        //then
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.get(carName)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"abc, 1", "def, 0"})
    void 자동차_전진_테스트(String carName, int position) {
        // given
        List<String> carNames = List.of("abc", "def");
        RacingCars racingCars = new RacingCars();
        Map<String, Integer> cars = racingCars.initializeCars(carNames);

        // when & then
        assertRandomNumberInRangeTest(
                () -> {
                    racingCars.attemptMoveCarsInOneRound();

                    // then
                    assertThat(cars.get(carName)).isEqualTo(position);
                },
                MOVING_FORWARD, STOP
        );
    }

}