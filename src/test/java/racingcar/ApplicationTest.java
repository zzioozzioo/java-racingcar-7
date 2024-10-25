package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
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
    void 이름이_5자_초과인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qwerty,abc", "2"))
                        .isInstanceOf(IllegalArgumentException.class));

    }

    @Test
    void 자동차_이름을_1개만_입력한_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qwert", "2"))
                        .isInstanceOf(IllegalArgumentException.class));

    }

    @Test
    void 쉼표와_쉼표_사이에_이름을_입력하지_않은_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("qwe,,abc", "3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_공백이_있는_경우() {
        assertSimpleTest(() -> {
            run("a , b,c", "2");
            assertThat(output()).contains("a : ");
            assertThat(output()).contains("b : ");
            assertThat(output()).contains("c : ");
        });
    }

    @Test
    void 시도할_횟수가_숫자가_아닌_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc", "a"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시도할_횟수가_1_미만이거나_100_초과인_경우() {
        assertAll(
                () -> assertThatThrownBy(() -> runException("qwe, rty", "0"))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> runException("qwe, rty", "101"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
