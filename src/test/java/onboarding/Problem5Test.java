package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem5Test {

    @Test
    void 정상적인_입력인_경우() {
        Assertions.assertThatCode(() -> Problem5.solution(1))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> Problem5.solution(1000000))
            .doesNotThrowAnyException();
    }

    @Test
    void 비정상적인_입력인_경우() {
        Assertions.assertThatThrownBy(() -> Problem5.solution(0));
        Assertions.assertThatThrownBy(() -> Problem5.solution(-1));
        Assertions.assertThatThrownBy(() -> Problem5.solution(1000001));
    }
}