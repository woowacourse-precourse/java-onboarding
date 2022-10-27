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
}