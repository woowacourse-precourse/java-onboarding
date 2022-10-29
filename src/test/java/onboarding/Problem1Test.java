package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {

    @Test
    void maxTest(){
        int a = 10;
        int b = 9;
        int maxValue = Problem1.max(a, b);
        assertThat(maxValue).isEqualTo(a);
    }


    @Test
    void calculateTest(){
        List<Integer> pages = List.of(100, 101);

        int maxValue = Problem1.calculate(pages);
        assertThat(maxValue).isEqualTo(2);
    }


}
