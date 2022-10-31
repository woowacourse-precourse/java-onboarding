package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {
    @Test
    void extraCase1() {
        List<Integer> pobi = List.of(-1, 0);
        List<Integer> crong = List.of(197, 198);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    void extraCase2() {
        List<Integer> pobi = List.of(1, 2);
        List<Integer> crong = List.of(401, 402);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }
}