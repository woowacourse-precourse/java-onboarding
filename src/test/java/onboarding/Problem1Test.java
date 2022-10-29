package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


class Problem1Test {

    @Test
    void solutionTest() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        // pobi == crong
        List<Integer> pobi1 = new ArrayList<>(Arrays.asList(123, 124));
        List<Integer> crong1 = new ArrayList<>(Arrays.asList(123, 124));

        // pobi > crong
        List<Integer> pobi2 = new ArrayList<>(Arrays.asList(197, 198));
        List<Integer> crong2 = new ArrayList<>(Arrays.asList(11, 12));

        // pobi < crong
        List<Integer> pobi3 = new ArrayList<>(Arrays.asList(11, 12));
        List<Integer> crong3 = new ArrayList<>(Arrays.asList(167, 168));

        // exception
        List<Integer> pobi4 = new ArrayList<>(Arrays.asList(122, 123));
        List<Integer> crong4 = new ArrayList<>(Arrays.asList(0, 1));

        //result
        int result1 = Problem1.solution(pobi1, crong1);
        int result2 = Problem1.solution(pobi2, crong2);
        int result3 = Problem1.solution(pobi3, crong3);
        int result4 = Problem1.solution(pobi4, crong4);
        Assertions.assertThat(result1).isEqualTo(0);
        Assertions.assertThat(result2).isEqualTo(1);
        Assertions.assertThat(result3).isEqualTo(2);
        Assertions.assertThat(result4).isEqualTo(-1);
    }
}