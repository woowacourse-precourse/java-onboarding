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
        int res = Problem1.pageValidation(input,1,400);

        //then
        Assertions.assertThat(res).isEqualTo(1);
    }

    @Test
    public void 페이지유효X() throws Exception {
        //given
        List<Integer> input = List.of(3, 5);

        //when
        int res = Problem1.pageValidation(input, 1, 400);

        //then
        Assertions.assertThat(res).isEqualTo(-1);
    }
}