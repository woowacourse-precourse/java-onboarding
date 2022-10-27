package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @Test
    public void 페이지유효() throws Exception {
        //given
        List<Integer> input = List.of(1, 2);

        //when
        boolean res = Problem1.isPageValid(input);

        //then
        Assertions.assertThat(res).isEqualTo(true);
    }

    @Test
    public void 페이지유효X() throws Exception {
        //given
        List<Integer> input = List.of(3, 5);

        //when
        boolean res = Problem1.isPageValid(input);

        //then
        Assertions.assertThat(res).isEqualTo(false);
    }

    @Test
    public void 페이지점수계산() throws Exception {
        //given
        Integer page = 51;

        //when
        int score = Problem1.calculateScore(51);

        //then
        Assertions.assertThat(score).isEqualTo(6);
    }

}