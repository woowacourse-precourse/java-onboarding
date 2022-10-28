package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Problem3Test {
    @Test
    public void 숫자리스트로변환() throws Exception {
        //given
        int num = 123;

        //when
        List<Integer> numElements = Problem3.getNumElements(123);

        //then
        Assertions.assertThat(numElements).isEqualTo(List.of(3, 2, 1));
    }

    @Test
    public void target숫자갯수() throws Exception {
        //given
        int number = 3369;

        //when
        int count = Problem3.countTargets(3369);

        //then
        Assertions.assertThat(count).isEqualTo(4);
    }
}