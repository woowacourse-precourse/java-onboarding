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

    @Test
    void 테스트케이스() {
        Assertions.assertThat(Problem1.solution(List.of(99, 103), List.of(211, 212)))
            .isEqualTo(-1);
        Assertions.assertThat(Problem1.solution(List.of(399, 400), List.of(211, 212)))
            .isEqualTo(1);
        Assertions.assertThat(Problem1.solution(List.of(401, 402), List.of(211, 212)))
            .isEqualTo(-1);
        Assertions.assertThat(Problem1.solution(List.of(99, 100), List.of(-1, 0)))
            .isEqualTo(-1);
        Assertions.assertThat(Problem1.solution(List.of(121, 122), List.of(211, 212)))
            .isEqualTo(0);
        Assertions.assertThat(Problem1.solution(List.of(121, 122, 123), List.of(211, 212)))
            .isEqualTo(-1);
        Assertions.assertThat(Problem1.solution(List.of(121, 122), List.of(212)))
            .isEqualTo(-1);
        Assertions.assertThat(Problem1.solution(List.of(122, 121), List.of(211, 212)))
            .isEqualTo(-1);
    }
}