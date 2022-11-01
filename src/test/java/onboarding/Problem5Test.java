package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem5Test {
    @Test
    void case1() {
        int money = 1_000_000;
        List<Integer> result = List.of(20, 0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(Problem5.solution(money)).isEqualTo(result);
    }

    @Test
    void case2() {
        int money = 164369;
        List<Integer> result = List.of(3, 1, 0, 4, 0, 3, 1, 1, 9);
        assertThat(Problem5.solution(money)).isEqualTo(result);
    }
}
