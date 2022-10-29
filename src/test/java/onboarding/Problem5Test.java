package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Problem5Test {
    @Test
    void solutionTest(){
        List<Integer> result1 = Problem5.solution(50237);
        List<Integer> result2 = Problem5.solution(15000);
        List<Integer> answer1 = Arrays.asList(1, 0, 0, 0, 0, 2, 0, 3, 7);
        List<Integer> answer2 = Arrays.asList(0, 1, 1, 0, 0, 0, 0, 0, 0);

        Assertions.assertThat(result1).isEqualTo(answer1);
        Assertions.assertThat(result2).isEqualTo(answer2);
    }

}