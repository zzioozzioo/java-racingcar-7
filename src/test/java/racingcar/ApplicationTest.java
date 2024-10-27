package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {

    // TODO: 테스트용 상수 관리 고민해보기
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    // TODO: 테스트명 작성법 고민해보기(제목에 한글로 설명 or 제목은 영어, @DisplayName으로 설명)

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름이 5자 초과인 경우")
    void 자동차_이름_예외_테스트_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qwerty,abc", "2"))
                        .isInstanceOf(IllegalArgumentException.class));

    }

    @Test
    @DisplayName("이름이 1개만 입력한 경우")
    void 자동차_이름_예외_테스트_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qwert", "2"))
                        .isInstanceOf(IllegalArgumentException.class));

    }

    @Test
    @DisplayName("쉼표와 쉼표 사이에 이름을 입력하지 않은 경우")
    void 자동차_이름_예외_테스트_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qwe,,abc", "3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    // TODO: ApplicationTest의 성격에 맞는 테스트인가? ValidatorTest 아닌가..?
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c"})
    @DisplayName("이름 앞,뒤에 공백이 있는 경우")
    void 기능_테스트_이름(String carName) {
        assertSimpleTest(() -> {
            run("a , b,c", "2");
            assertThat(output()).contains(String.format("%s : ", carName));
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"a b", "c d", "e"})
    @DisplayName("이름에 공백이 포함된 경우")
    void 기능_테스트_이름_2(String carName) {
        assertSimpleTest(() -> {
            run("a b, c d, e", "2");
            assertThat(output()).contains(String.format("%s : ", carName));
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ㄱ", "#"})
    @DisplayName("시도할 횟수가 숫자가 아닌 경우")
    void 시도_횟수_예외_테스트_1(String tryCount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc", tryCount))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @ParameterizedTest
    @CsvSource({"qwe, rty, 0", "qwe, rty, 101"})
    @DisplayName("시도할 횟수가 범위에서 벗어난 경우")
    void 시도_횟수_예외_테스트_2(String carName1, String carName2, String tryCount) {
        assertAll(
                () -> assertThatThrownBy(() -> runException(carName1, carName2, tryCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
