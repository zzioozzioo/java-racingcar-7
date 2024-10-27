package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    // TODO: 테스트용 상수 관리 고민해보기
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

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

//    @ParameterizedTest
//    @ValueSource(strings = {"a", "b", "c"})
//    @DisplayName("이름 앞,뒤에 공백이 있는 경우")
//    void 기능_테스트_이름(String carName) {
//        assertSimpleTest(() -> {
//            run("a , b,c", "2");
//            assertThat(output()).contains(String.format("%s : ", carName));
//        });
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"a b", "c d", "e"})
//    @DisplayName("이름에 공백이 포함된 경우")
//    void 기능_테스트_이름_2(String carName) {
//        assertSimpleTest(() -> {
//            run("a b, c d, e", "2");
//            assertThat(output()).contains(String.format("%s : ", carName));
//        });
//    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
