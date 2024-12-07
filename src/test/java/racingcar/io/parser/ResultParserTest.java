package racingcar.io.parser;

import static racingcar.constants.StringConstants.NEW_LINE;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class ResultParserTest {

    @Test
    void 하나의_라운드_결과_파싱하기() {
        //given
        ResultParser resultParser = new ResultParser();

        List<Car> cars = getCars();
        int round = 2;

        //when
        String result = resultParser.parseOneRoundResult(cars, round);

        //then
        Assertions.assertThat(result).contains(
                """
                        포비 : --
                        크롱 : -        
                        """
        );

    }

    private List<Car> getCars() {
        Car car1 = new Car("포비");
        Car car2 = new Car("크롱");

        car1.moveOrNot(true, 1);
        car2.moveOrNot(true, 1);

        car1.moveOrNot(true, 2);
        car2.moveOrNot(false, 2);

        return new ArrayList<>(List.of(car1, car2));
    }

    @Test
    void 전체_결과_파싱하기() {
        //given
        ResultParser resultParser = new ResultParser();

        List<String> winners = getWinners();

        //when
        String result = resultParser.parseRaceResult(winners);

        //then
        Assertions.assertThat(result).isEqualTo("포비" + NEW_LINE);
    }

    private List<String> getWinners() {
        return List.of("포비");
    }
}