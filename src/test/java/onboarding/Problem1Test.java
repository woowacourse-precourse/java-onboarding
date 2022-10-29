package onboarding;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem1Test {

    @Test
    void 정상적인_입력값인_경우() {
        Assertions.assertThat(Problem1.solution(List.of(1, 2), List.of(3, 4)))
            .isNotNegative();
    }

    @Test
    void 비정상적인_입력값인_경우() {
        Assertions.assertThat(Problem1.solution(List.of(2, 3), List.of(3, 4)))
            .isNegative();
        Assertions.assertThat(Problem1.solution(List.of(2, 5), List.of(3, 4)))
            .isNegative();
        Assertions.assertThat(Problem1.solution(List.of(1, 2), List.of(3, 4, 5)))
            .isNegative();
    }
}