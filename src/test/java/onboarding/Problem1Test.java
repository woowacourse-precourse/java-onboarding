package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem1Test {
    Problem1 problem = new Problem1();
    @Test
    @DisplayName("List Size Test")
    void listSize() {
        List<Integer> list = List.of(197, 198, 199);
        boolean result = true;
        assertThat(problem.listSizeException(list)).isEqualTo(result);
    }

    @Test
    @DisplayName("Page Num Test")
    void pageNum() {
        List<Integer> list1 = List.of(1, 2);
        List<Integer> list2 = List.of(399, 400);
        List<Integer> list3 = List.of(98, 99);
        List<Integer> list4 = List.of(1, 4);
        boolean result1 = true;
        boolean result2 = true;
        boolean result3 = false;
        boolean result4 = true;
        assertThat(problem.pageNumException(list1)).isEqualTo(result1);
        assertThat(problem.pageNumException(list2)).isEqualTo(result2);
        assertThat(problem.pageNumException(list3)).isEqualTo(result3);
        assertThat(problem.pageNumException(list4)).isEqualTo(result4);
    }

    @Test
    @DisplayName("Page Index Test")
    void pageIndex() {
        List<Integer> list1 = List.of(1, 3);
        List<Integer> list2 = List.of(197, 198);
        List<Integer> list3 = List.of(98, 99);
        boolean result1 = true; // Page Index Error가 발생함 -> true
        boolean result2 = false;
        boolean result3 = true;
        assertThat(problem.pageIndexException(list1)).isEqualTo(result1);
        assertThat(problem.pageIndexException(list2)).isEqualTo(result2);
        assertThat(problem.pageIndexException(list3)).isEqualTo(result3);
    }

    @Test
    @DisplayName("Sum Each Num Test")
    void sumEachNum() {
        assertThat(problem.sumEachNum(12)).isEqualTo(3);
        assertThat(problem.sumEachNum(197)).isEqualTo(17);
        assertThat(problem.sumEachNum(5)).isEqualTo(5);
    }

    @Test
    @DisplayName("Multiply Each Num Test")
    void multiEachNum() {
        assertThat(problem.multiEachNum(12)).isEqualTo(2);
        assertThat(problem.multiEachNum(197)).isEqualTo(63);
        assertThat(problem.multiEachNum(300)).isEqualTo(0);
    }

    @Test
    @DisplayName("Get Max Score Test")
    void getScoreTest() {
        List<Integer> list1 = List.of(197, 198);
        List<Integer> list2 = List.of(299, 300);
        List<Integer> list3 = List.of(101, 102);
        assertThat(problem.getScore(list1)).isEqualTo(72);
        assertThat(problem.getScore(list2)).isEqualTo(162);
        assertThat(problem.getScore(list3)).isEqualTo(3);
    }
}
