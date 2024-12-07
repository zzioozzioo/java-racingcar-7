package racingcar.io.parser;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "abc, abcdefg", "가나다, 가나다", "가, 가나, 가나다, 가나다라, 가나다라마, 마라다나가, 라다나가, 다나가, 나가, 가가"})
    void 자동차_이름_파싱하기_예외_테스트(String input) {
        //given
        InputParser inputParser = new InputParser();

        //when & then
        Assertions.assertThatThrownBy(() -> inputParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "가나다", "0", "11", "100"})
    void 시도_횟수_파싱하기_예외_테스트(String input) {
        //given
        InputParser inputParser = new InputParser();

        //when & then
        Assertions.assertThatThrownBy(() -> inputParser.parseTryCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}