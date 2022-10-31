package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {
    @Test
    void moneyIsZeroCase() {
        int money = 0;
        List<Integer> result = List.of(0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(Problem5.solution(money)).isEqualTo(result);
    }
    @Test
    void case1() {
        int money = 101;
        List<Integer> result = List.of(0, 0, 0, 0, 0, 1, 0, 0, 1);
        assertThat(Problem5.solution(money)).isEqualTo(result);
    }

}