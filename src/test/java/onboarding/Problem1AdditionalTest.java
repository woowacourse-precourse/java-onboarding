package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1AdditionalTest {

    @Test
    @DisplayName("책 페이지가 순서대로 제공하지 않음")
    void pagesOutOfOrder() throws Exception {
        //given
        List<Integer> pobi = List.of(96, 98);
        List<Integer> crong = List.of(197, 198);
        //when
        int result = Problem1.solution(pobi, crong);
        //then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("책 페이지 초과")
    void pagesExceeded() throws Exception {
        //given
        List<Integer> pobi = List.of(399, 400);
        List<Integer> crong = List.of(197, 198);
        //when
        int result = Problem1.solution(pobi, crong);
        //then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("책 페이지 역으로 초과")
    void pagesExceededInversely() throws Exception {
        //given
        List<Integer> pobi = List.of(299, 100);
        List<Integer> crong = List.of(197, 198);
        //when
        int result = Problem1.solution(pobi, crong);
        //then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("책 페이지 홀짝 안맞음")
    void pagesNotFitOddEven() throws Exception {
        //given
        List<Integer> pobi = List.of(100, 101);
        List<Integer> crong = List.of(197, 198);
        //when
        int result = Problem1.solution(pobi, crong);
        //then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱이 더 큰 경우")
    void SumIsLargest() throws Exception {
        //given
        List<Integer> pobi = List.of(309, 310);
        List<Integer> crong = List.of(127, 128);
        //when
        int result = Problem1.solution(pobi, crong);
        //then
        assertThat(result).isEqualTo(2);
    }
}
