package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("문제 1번")
public class Problem1Test {
    @Test
    void case1() {
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);
        int result = 0;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    void case2() {
        List<Integer> pobi = List.of(131, 132);
        List<Integer> crong = List.of(211, 212);
        int result = 1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("페이지 번호의 각 자리 숫자의 총합과 총곱 중 131이 주어지면 총합인 5가 더 크다.")
    void calculatePageScore_With131_WillBe5() {
        int pageNumber = 131;
        int result = 5;
        assertThat(Problem1.calculatePageScore(pageNumber)).isEqualTo(result);
    }

    @Test
    @DisplayName("입력값 무효 #1, 왼쪽 페이지 번호가 홀수가 아니다.")
    void invalidInput_LeftPageNumberIsNotOdd() {
        List<Integer> pobi = List.of(100, 102);
        List<Integer> crong = List.of(211, 212);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("입력값 무효 #2, 오른쪽 페이지 번호가 짝수가 아니다.")
    void invalidInput_RightPageNumberIsNotEven() {
        List<Integer> pobi = List.of(299, 300);
        List<Integer> crong = List.of(93, 95);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("입력값 무효 #3, 페이지 번호가 1 미만이다.")
    void invalidInput_PageNumberIsLessThan1() {
        List<Integer> pobi = List.of(-1, 0);
        List<Integer> crong = List.of(211, 212);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("입력값 무효 #4, 페이지 번호가 400을 초과한다.")
    void invalidInput_PageNumberIsMoreThan400() {
        List<Integer> pobi = List.of(33, 34);
        List<Integer> crong = List.of(401, 402);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("입력값 무효 #5, 왼쪽과 오른쪽 페이지 번호가 연속적이지 않다.")
    void invalidInput_NotContinousPageNumber() {
        List<Integer> pobi = List.of(99, 102);
        List<Integer> crong = List.of(211, 212);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("입력값 무효 #6, 왼쪽 페이지 번호가 오른쪽 페이지 번호 보다 더 크다.")
    void invalidInput_LeftIsBiggerThanRight() {
        List<Integer> pobi = List.of(99, 100);
        List<Integer> crong = List.of(213, 210);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("입력값 무효 #7, 페이지 번호가 시작 면이다.")
    void invalidInput_PageNumberIsStartPage() {
        List<Integer> pobi = List.of(99, 100);
        List<Integer> crong = List.of(213, 210);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("입력값 무효 #8, 페이지 번호가 마지막 면이다.")
    void invalidInput_PageNumberIsEndPage() {
        List<Integer> pobi = List.of(99, 100);
        List<Integer> crong = List.of(213, 210);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }
}

