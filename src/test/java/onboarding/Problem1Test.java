package onboarding;

import org.junit.jupiter.api.Test;
import utils.Problem1Util;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class Problem1Test {

    @Test
    void sumAndMultiplyTest() {
        List<Integer> nums = Arrays.asList(21, 22);
        int result = Problem1Util.getMaxBetweenSumAndMultiply(nums);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void whoIsWinnerTest() {
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);
        int pobiResult = Problem1Util.getMaxBetweenSumAndMultiply(pobi);
        int crongResult = Problem1Util.getMaxBetweenSumAndMultiply(crong);
        int result = Problem1Util.whoIsWinner(pobiResult, crongResult);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void ex_unValidNum() {
        List<Integer> pobi = List.of(98, 99);
        int result = Problem1Util.getMaxBetweenSumAndMultiply(pobi);
        assertThat(result).isEqualTo(-1);
    }
}