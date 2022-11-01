package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem3Test {

    @Test
    void 정상적인_입력인_경우() {
        Assertions.assertThatCode(() -> Problem3.solution(1))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> Problem3.solution(10000))
            .doesNotThrowAnyException();
    }

    @Test
    void 비정상적인_입력인_경우() {
        Assertions.assertThatThrownBy(() -> Problem3.solution(0));
        Assertions.assertThatThrownBy(() -> Problem3.solution(-1));
        Assertions.assertThatThrownBy(() -> Problem3.solution(10001));
    }

    @Test
    void 테스트케이스() {
        Assertions.assertThat(Problem3.solution(333))
            .isEqualTo(228);
        Assertions.assertThat(Problem3.solution(2))
            .isEqualTo(0);
    }
}