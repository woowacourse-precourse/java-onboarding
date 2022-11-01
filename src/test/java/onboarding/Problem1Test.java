package onboarding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {

    private Problem1 problem1;

    @BeforeEach
    void setUp() {
        problem1 = new Problem1();
    }

    @Test
    @DisplayName("페이지 번호 타당성 에러를 맞게 판단하는지")
    void checkPageNumberValidityExceptionTest() {
        List<Integer> exceptionCase1 = List.of(99, 102);
        assertThat(problem1.checkPageNumberValidityException(exceptionCase1)).isFalse();

        List<Integer> exceptionCase2 = List.of(100, 101);
        assertThat(problem1.checkPageNumberValidityException(exceptionCase2)).isFalse();

        List<Integer> exceptionCase3 = List.of(101, 100);
        assertThat(problem1.checkPageNumberValidityException(exceptionCase3)).isFalse();

        List<Integer> correctCase1 = List.of(99, 100);
        assertThat(problem1.checkPageNumberValidityException(correctCase1)).isTrue();

        List<Integer> correctCase2 = List.of(101, 102);
        assertThat(problem1.checkPageNumberValidityException(correctCase2)).isTrue();
    }

    @Test
    @DisplayName("페이지 번호 범위 에러를 맞게 판단하는지")
    void checkOutOfRangeExceptionTest() {

        List<Integer> exceptionCase1 = List.of(1, 2);
        assertThat(problem1.checkOutOfRangeException(exceptionCase1)).isFalse();

        List<Integer> exceptionCase2 = List.of(399, 400);
        assertThat(problem1.checkOutOfRangeException(exceptionCase2)).isFalse();

        List<Integer> exceptionCase3 = List.of(-1, 0);
        assertThat(problem1.checkOutOfRangeException(exceptionCase3)).isFalse();

        List<Integer> exceptionCase4 = List.of(401, 402);
        assertThat(problem1.checkOutOfRangeException(exceptionCase4)).isFalse();

        List<Integer> correctCase1 = List.of(3, 4);
        assertThat(problem1.checkOutOfRangeException(correctCase1)).isTrue();
    }

    @Test
    @DisplayName("전체 에러를 맞게 확인하는지")
    void checkExceptionTest() {

        List<Integer> exceptionCase1 = List.of(99, 102);
        assertThat(problem1.checkException(exceptionCase1)).isFalse();

        List<Integer> exceptionCase2 = List.of(100, 101);
        assertThat(problem1.checkException(exceptionCase2)).isFalse();

        List<Integer> exceptionCase3 = List.of(399, 400);
        assertThat(problem1.checkException(exceptionCase3)).isFalse();

        List<Integer> exceptionCase4 = List.of(-1, 0);
        assertThat(problem1.checkException(exceptionCase4)).isFalse();

        List<Integer> exceptionCase5 = List.of(398, 399);
        assertThat(problem1.checkException(exceptionCase5)).isFalse();

        List<Integer> correctCase1 = List.of(3, 4);
        assertThat(problem1.checkException(correctCase1)).isTrue();
    }

    @Test
    @DisplayName("리스트 각 요소의 자릿수 덧셈을 잘 하는지")
    void addEachDigitOfPageNumber() {
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
        List<Integer> list1 = List.of(99, 100);
        List<Integer> result1 = List.of(18, 1, 81, 0);
        List<Integer> list2 = List.of(101, 102);
        List<Integer> result2 = List.of(2, 3, 0, 0);

        assertThat(problem1.calculateEachDigitOfPageNumber(list1)).isEqualTo(result1);
        assertThat(problem1.calculateEachDigitOfPageNumber(list2)).isEqualTo(result2);
    }

    @Test
    @DisplayName("리스트의 최댓값을 반환하는지")
    void getMaxValueTest() {
        List<Integer> list1 = List.of(18, 1, 81, 0);
        int result1 = 81;

        assertThat(problem1.getMaxValue(list1)).isEqualTo(result1);
    }

    @Test
    @DisplayName("올바른 승부 결과를 판단하는지")
    void findWinnerTest() {
        List<Integer> pobiWinCase = List.of(7, 1);
        int pobiWin = 1;
        assertThat(problem1.findWinner(pobiWinCase)).isEqualTo(pobiWin);

        List<Integer> crongWinCase = List.of(5, 6);
        int crongWin = 2;
        assertThat(problem1.findWinner(crongWinCase)).isEqualTo(crongWin);

        List<Integer> noWinnerCase = List.of(3, 3);
        int noWinner = 0;
        assertThat(problem1.findWinner(noWinnerCase)).isEqualTo(noWinner);
    }
}