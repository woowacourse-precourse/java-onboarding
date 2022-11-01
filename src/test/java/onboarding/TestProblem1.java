package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestProblem1 {

    @Test
    void TestsumDigit() {
        assertThat(Problem1.sumDigit(97)).isEqualTo(16);
        assertThat(Problem1.sumDigit(98)).isEqualTo(17);
        assertThat(Problem1.sumDigit(131)).isEqualTo(5);
        assertThat(Problem1.sumDigit(99)).isEqualTo(18);
        assertThat(Problem1.sumDigit(197)).isEqualTo(17);
    }

    @Test
    void TestmultiplyDigit(){
        assertThat(Problem1.multiplyDigit(97)).isEqualTo(63);
        assertThat(Problem1.multiplyDigit(98)).isEqualTo(72);
        assertThat(Problem1.multiplyDigit(131)).isEqualTo(3);
        assertThat(Problem1.multiplyDigit(132)).isEqualTo(6);
        assertThat(Problem1.multiplyDigit(198)).isEqualTo(72);
    }

    @Test
    void TestisInRange(){
        List<Integer> T1 = List.of(101, 102);
        List<Integer> T2 = List.of(197, 198);
        List<Integer> T3 = List.of(97, 98);
        List<Integer> T4 = List.of(2, 3);
        assertThat(Problem1.isInRange(T1)).isEqualTo(true);
        assertThat(Problem1.isInRange(T2)).isEqualTo(true);
        assertThat(Problem1.isInRange(T3)).isEqualTo(true);
        assertThat(Problem1.isInRange(T4)).isEqualTo(true);
    }

    @Test
    void TestisOdd(){
        assertThat(Problem1.isOdd(100)).isEqualTo(false);
        assertThat(Problem1.isOdd(99)).isEqualTo(true);
    }

    @Test
    void TestisEven(){
        assertThat(Problem1.isEven(100)).isEqualTo(true);
        assertThat(Problem1.isEven(99)).isEqualTo(false);
    }

    @Test
    void TestisNotStartOrEnd(){
        List<Integer> T1 = List.of(3, 4);
        List<Integer> T2 = List.of(1, 2);
        List<Integer> T3 = List.of(399, 400);
        List<Integer> T4 = List.of(123,124);

        assertThat(Problem1.isNotStartOrEnd(T1)).isEqualTo(true);
        assertThat(Problem1.isNotStartOrEnd(T2)).isEqualTo(false);
        assertThat(Problem1.isNotStartOrEnd(T3)).isEqualTo(false);
        assertThat(Problem1.isNotStartOrEnd(T4)).isEqualTo(true);
    }

    @Test
    void TestSoulution(){
        List<Integer> T1_a = List.of(-1, 0);
        List<Integer> T1_b = List.of(400, 401);

        List<Integer> T2_a = List.of(100, 101);
        List<Integer> T2_b = List.of(102, 103);

        List<Integer> T3_a = List.of(1, 400);
        List<Integer> T3_b = List.of(101, 399);

        List<Integer> T4_a = List.of(399, 400);
        List<Integer> T4_b = List.of(1, 2);

        assertThat(Problem1.solution(T1_a, T1_b)).isEqualTo(-1);
        assertThat(Problem1.solution(T2_a, T2_b)).isEqualTo(-1);
        assertThat(Problem1.solution(T3_a, T3_b)).isEqualTo(-1);
        assertThat(Problem1.solution(T4_a, T4_b)).isEqualTo(-1);
    }
}
