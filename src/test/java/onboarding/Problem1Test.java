package onboarding;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {

    @Test
    void 자리수() {
        List<Integer> list = Arrays.asList(7,9);
        assertThat(jarisoo(97)).isEqualTo(list);
    }
    static List<Integer> jarisoo(int num) {
        List<Integer> numArr = new ArrayList<Integer>();
        while(num > 0){
            numArr.add(num % 10);
            num /= 10;
        }
        return numArr;
    }

    @Test
    void 더하기() {
        List<Integer> list = Arrays.asList(9,7);
        assertThat(plus(list)).isEqualTo(16);
    }
    static int plus(List<Integer> nums) {
        int plus = 0;
        for(int i : nums) plus += i;
        return plus;
    }

    @Test
    void 곱하기() {
        List<Integer> list = Arrays.asList(9,7);
        assertThat(multiply(list)).isEqualTo(63);
    }
    static int multiply(List<Integer> nums) {
        int result = 1;
        for(int i : nums) result *= i;
        return result;
    }

    @Test
    void 최대값_구하기() {
        List<Integer> list = Arrays.asList(97,98);
        assertThat(maxNum(list)).isEqualTo(72);
    }
    static int maxNum(List<Integer> nums) {
        int maxNum = 0;
        for (int i : nums) {
            List<Integer> jariArr = jarisoo(i);
            int temp = Math.max(plus(jariArr),multiply(jariArr));
            if (maxNum < temp) maxNum = temp;
        }
        return maxNum;
    }
}