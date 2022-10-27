package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {

    @Test
    @DisplayName("페이지 번호 타당성 에러를 맞게 판단하는지")
    void checkPageNumberValidityExceptionTest() {
        Problem1 problem1 = new Problem1();
        boolean result = true;

        List<Integer> exceptionCase1 = List.of(99, 102);
        assertThat(problem1.checkPageNumberValidityException(exceptionCase1)).isNotEqualTo(result);

        List<Integer> exceptionCase2 = List.of(100, 101);
        assertThat(problem1.checkPageNumberValidityException(exceptionCase2)).isNotEqualTo(result);

        List<Integer> exceptionCase3 = List.of(101, 100);
        assertThat(problem1.checkPageNumberValidityException(exceptionCase3)).isNotEqualTo(result);

        List<Integer> correctCase1 = List.of(99, 100);
        assertThat(problem1.checkPageNumberValidityException(correctCase1)).isEqualTo(result);

        List<Integer> correctCase2 = List.of(101, 102);
        assertThat(problem1.checkPageNumberValidityException(correctCase2)).isEqualTo(result);
    }

    @Test
    @DisplayName("페이지 번호 범위 에러를 맞게 판단하는지")
    void checkOutOfRangeExceptionTest() {
        Problem1 problem1 = new Problem1();
        boolean result = true;

        List<Integer> exceptionCase1 = List.of(1,2);
        assertThat(problem1.checkOutOfRangeException(exceptionCase1)).isNotEqualTo(result);

        List<Integer> exceptionCase2 = List.of(399, 400);
        assertThat(problem1.checkOutOfRangeException(exceptionCase2)).isNotEqualTo(result);

        List<Integer> exceptionCase3 = List.of(-1, 0);
        assertThat(problem1.checkOutOfRangeException(exceptionCase3)).isNotEqualTo(result);

        List<Integer> exceptionCase4 = List.of(401, 402);
        assertThat(problem1.checkOutOfRangeException(exceptionCase4)).isNotEqualTo(result);

        List<Integer> correctCase1 = List.of(3, 4);
        assertThat(problem1.checkOutOfRangeException(correctCase1)).isEqualTo(result);
    }

    @Test
    @DisplayName("전체 에러를 맞게 확인하는지")
    void checkExceptionTest() {
        Problem1 problem1 = new Problem1();
        boolean result = true;

        List<Integer> exceptionCase1 = List.of(99, 102);
        assertThat(problem1.checkException(exceptionCase1)).isNotEqualTo(result);

        List<Integer> exceptionCase2 = List.of(100, 101);
        assertThat(problem1.checkException(exceptionCase2)).isNotEqualTo(result);

        List<Integer> exceptionCase3 = List.of(399, 400);
        assertThat(problem1.checkException(exceptionCase3)).isNotEqualTo(result);

        List<Integer> exceptionCase4 = List.of(-1, 0);
        assertThat(problem1.checkException(exceptionCase4)).isNotEqualTo(result);

        List<Integer> exceptionCase5 = List.of(398, 399);
        assertThat(problem1.checkException(exceptionCase5)).isNotEqualTo(result);

        List<Integer> correctCase1 = List.of(3, 4);
        assertThat(problem1.checkException(correctCase1)).isEqualTo(result);
    }

    @Test
    @DisplayName("리스트 각 요소의 자릿수 덧셈을 잘 하는지")
    void addEachDigitOfPageNumber() {
        Problem1 problem1 = new Problem1();
        List<Integer> list1 = List.of(99, 100);
        List<Integer> result1 = List.of(18, 1);
        List<Integer> list2 = List.of(101, 102);
        List<Integer> result2 = List.of(2, 3);

        assertThat(problem1.addEachDigitOfPageNumber(list1)).isEqualTo(result1);
        assertThat(problem1.addEachDigitOfPageNumber(list2)).isEqualTo(result2);
    }

    @Test
    @DisplayName("리스트 각 요소의 자릿수 곱셈을 잘 하는지")
    void multiplyEachDigitOfPageNumberTest() {
        Problem1 problem1 = new Problem1();
        List<Integer> list1 = List.of(99, 100);
        List<Integer> result1 = List.of(81, 0);
        List<Integer> list2 = List.of(101, 102);
        List<Integer> result2 = List.of(0, 0);

        assertThat(problem1.multiplyEachDigitOfPageNumber(list1)).isEqualTo(result1);
        assertThat(problem1.multiplyEachDigitOfPageNumber(list2)).isEqualTo(result2);
    }

    @Test
    @DisplayName("리스트 각 요소의 자릿수 연산을 잘 하는지")
    void calculateEachDigitOfPageNumberTest() {
        Problem1 problem1 = new Problem1();
        List<Integer> list1 = List.of(99, 100);
        List<Integer> result1 = List.of(18, 1, 81, 0);
        List<Integer> list2 = List.of(101, 102);
        List<Integer> result2 = List.of(2, 3, 0, 0);

        assertThat(problem1.calculateEachDigitOfPageNumber(list1)).isEqualTo(result1);
        assertThat(problem1.calculateEachDigitOfPageNumber(list2)).isEqualTo(result2);
    }
}