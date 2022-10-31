package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem1Test {
    @Test
    @DisplayName("400 포함")
    void case1() {
        List<Integer> pobi = List.of(399, 400);
        List<Integer> crong = List.of(197, 198);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("list 길이 3")
    void case2() {
        List<Integer> pobi = List.of(3, 4, 5);
        List<Integer> crong = List.of(197, 198);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("1 포함")
    void case3() {
        List<Integer> pobi = List.of(143, 144);
        List<Integer> crong = List.of(1, 2);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("왼쪽 페이지 짝수")
    void case4() {
        List<Integer> pobi = List.of(4, 5);
        List<Integer> crong = List.of(197, 198);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName(("오른쪽 페이지 홀수"))
    void case5() {
        List<Integer> pobi = List.of(4, 5);
        List<Integer> crong = List.of(198, 199);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("연속된 페이지가 아님")
    void case6() {
        List<Integer> pobi = List.of(9, 8);
        List<Integer> crong = List.of(299, 300);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("연속된 페이지가 아님")
    void case7() {
        List<Integer> pobi = List.of(100, 104);
        List<Integer> crong = List.of(103, 104);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("무승부")
    void case8() {
        List<Integer> pobi = List.of(121, 122);
        List<Integer> crong = List.of(211, 212);
        int result = 0;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }
}
