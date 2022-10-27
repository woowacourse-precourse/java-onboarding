package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.Problem1Util;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class Problem1Test {

    @Test
    void sumAndMultiplyTest() {
        List<Integer> nums1 = Arrays.asList(21, 22);
        List<Integer> nums2 = Arrays.asList(35, 36);
        assertThat(Problem1Util.getMaxBetweenSumAndMultiply(nums1)).isEqualTo(4);
        assertThat(Problem1Util.getMaxBetweenSumAndMultiply(nums2)).isEqualTo(18);
    }

    @Nested
    class WinnerTest {
        @Test
        @DisplayName("무승부인 경우")
        void case1() {
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(197, 198);
            int pobiResult = Problem1Util.getMaxBetweenSumAndMultiply(pobi);
            int crongResult = Problem1Util.getMaxBetweenSumAndMultiply(crong);
            int result = Problem1Util.whoIsWinner(pobiResult, crongResult);
            assertThat(result).isEqualTo(0);
        }


        @Test
        @DisplayName("pobi가 이긴 경우")
        void case2() {
            List<Integer> pobi = List.of(99, 100);
            List<Integer> crong = List.of(197, 198);
            int pobiResult = Problem1Util.getMaxBetweenSumAndMultiply(pobi);
            int crongResult = Problem1Util.getMaxBetweenSumAndMultiply(crong);
            int result = Problem1Util.whoIsWinner(pobiResult, crongResult);
            assertThat(result).isEqualTo(1);
        }

        @Test
        @DisplayName("crong이가 이긴 경우")
        void case3() {
            List<Integer> pobi = List.of(99, 100);
            List<Integer> crong = List.of(299, 300);
            int pobiResult = Problem1Util.getMaxBetweenSumAndMultiply(pobi);
            int crongResult = Problem1Util.getMaxBetweenSumAndMultiply(crong);
            int result = Problem1Util.whoIsWinner(pobiResult, crongResult);
            assertThat(result).isEqualTo(2);
        }
    }

    @Nested
    class validTest {
        @Test
        @DisplayName("정상 입력")
        void case1() {
            assertThat(Problem1Util.getMaxBetweenSumAndMultiply(List.of(3, 4))).isEqualTo(4);
            assertThat(Problem1Util.getMaxBetweenSumAndMultiply(List.of(101, 102))).isEqualTo(3);
            assertThat(Problem1Util.getMaxBetweenSumAndMultiply(List.of(397, 398))).isEqualTo(216);
        }

        @Test
        @DisplayName("잘못된 입력 - [짝수, 홀수]")
        void case2() {
            assertThat(Problem1Util.getMaxBetweenSumAndMultiply(List.of(98, 99))).isEqualTo(-1);
            assertThat(Problem1Util.getMaxBetweenSumAndMultiply(List.of(2, 3))).isEqualTo(-1);
            assertThat(Problem1Util.getMaxBetweenSumAndMultiply(List.of(398, 399))).isEqualTo(-1);
        }

        @Test
        @DisplayName("잘못된 입력 - 범위값을 벗어난 입력")
        void case3() {
            assertThat(Problem1Util.getMaxBetweenSumAndMultiply(List.of(399, 400))).isEqualTo(-1);
            assertThat(Problem1Util.getMaxBetweenSumAndMultiply(List.of(1, 2))).isEqualTo(-1);
        }

        @Test
        @DisplayName("잘못된 입력 - 잘못된 입력")
        void case4() {
            // 입력값이 없는 경우
            assertThat(Problem1Util.getMaxBetweenSumAndMultiply(List.of())).isEqualTo(-1);

            // 입력값이 하나인 경우
            assertThat(Problem1Util.getMaxBetweenSumAndMultiply(List.of(3))).isEqualTo(-1);

            // 입력값이 세 개 이상인 경우
            assertThat(Problem1Util.getMaxBetweenSumAndMultiply(List.of(101, 102, 103))).isEqualTo(-1);
            assertThat(Problem1Util.getMaxBetweenSumAndMultiply(List.of(101, 102, 103, 104))).isEqualTo(-1);
        }
    }

}