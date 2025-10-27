package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest extends NsTest {
    @Test
    @DisplayName("[자동차 이름 입력, 시도 횟수 입력 공통 예외 테스트] 공백 입력 테스트")
    void exceptionEmptyInputTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("[시도 횟수 예외테스트] 양의 정수 인지 확인")
    void exceptionPostiveTryNumberTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("[시도 횟수 예외테스트] 숫자가 아닌 다른 문자일 경우인지 확인")
    void exceptionNoneNumberTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("[시도 횟수 예외테스트] Integer의 최대값 범위를 넘어선 오버플로우 테스트")
    void exceptionOverflowTryNumberTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "2147483648"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("[자동차 이름 추출 예외테스트] 자동차 이름에 숫자, 한글, 영어를 제외한 문자가 이름에 포함될 경우인지 확인")
    void exceptionCarNameFormatTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi*", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("[자동차 이름 추출 예외테스트] 연속된 구분자가 입력된 경우의 테스트")
    void exceptionLinearDelimiterTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,, jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("[자동차 이름 추출 예외테스트] 구분자가 정확한 형식으로 입력 되지 않을 경우의 테스트")
    void exceptionInvalidDelimiterFormatTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi, kala,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("[자동차 이름 추출 예외테스트] 각 자동차 이름의 길이가 5를 초과하는 경우의 테스트")
    void exceptionCarNameLengthTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi is free", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("[자동차 이름 추출 예외테스트] 각 자동차 이름이 중복될 경우의 테스트")
    void exceptionDuplicateCarNameTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("twin, twin", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
