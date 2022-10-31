package onboarding.Problem5Test;

import onboarding.Problem5;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
public class P5ResultTest {
    @Test
    void case1(){
        int money = 1;
        List<Integer> result = List.of(0, 0, 0, 0, 0, 0, 0, 0, 1);
        assertThat(Problem5.solution(money)).isEqualTo(result);
    }
    @Test
    void case2(){
        int money = 66661;
        List<Integer> result = List.of(1, 1, 1, 1, 1, 1, 1, 1, 1);
        assertThat(Problem5.solution(money)).isEqualTo(result);
    }

    @Test
    void case3(){
        int money = 55550;
        List<Integer> result = List.of(1, 0, 1, 0, 1, 0, 1, 0, 0);
        assertThat(Problem5.solution(money)).isEqualTo(result);
    }
}
