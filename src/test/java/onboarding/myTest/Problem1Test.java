package onboarding.myTest;

import onboarding.Problem1;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem1Test {


    @Test
    void case1() {
        List<Integer> pobi = List.of(1, 2);
        List<Integer> crong = List.of(197, 198);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    void case2() {
        List<Integer> pobi = List.of(3, 4);
        List<Integer> crong = List.of(399, 400);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    void case3() {
        List<Integer> pobi = List.of(401, 402);
        List<Integer> crong = List.of(1,2);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }




}
