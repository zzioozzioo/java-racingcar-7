package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_초기화_테스트() {
        //given
        String[] splitCarName = {"abc", "def"};

        RacingCars racingCars = new RacingCars();
        Map<String, Integer> cars;

        //when
        cars = racingCars.initializeCars(splitCarName);

        //then
        assertThat(cars.size()).isEqualTo(2);
        // TODO: 각 key의 value가 0인 것도 테스트하기
    }

    @Test
    void 자동차_전진_테스트() {
        // given
        String[] carNames = {"abc", "def"};
        RacingCars racingCars = new RacingCars();
        Map<String, Integer> cars = racingCars.initializeCars(carNames);

        // when & then
        assertRandomNumberInRangeTest(
                () -> {
                    racingCars.raceOneRound();

                    // then
                    assertThat(cars.get("abc")).isEqualTo(1);  // abc는 전진함
                    assertThat(cars.get("def")).isEqualTo(0);  // def는 전진하지 않음
                },
                MOVING_FORWARD, STOP
        );
    }

}