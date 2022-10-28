package onboarding.Problem5Test;

import onboarding.Problem5;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
public class P5InputExceptionTest {
    @Test
    void case1(){
        int money = 0;
        List<Integer> result = List.of(0,0,0,0,0,0,0,0,0);
        assertThat(Problem5.solution(money)).isEqualTo(result);
    }
    @Test
    void case2(){
        int money = 1000001;
        List<Integer> result = List.of(0,0,0,0,0,0,0,0,0);
        assertThat(Problem5.solution(money)).isEqualTo(result);
    }
}
