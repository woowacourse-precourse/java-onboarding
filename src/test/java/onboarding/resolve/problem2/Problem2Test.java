package onboarding.resolve.problem2;

import static org.assertj.core.api.Assertions.assertThat;

import onboarding.Problem2;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class Problem2Test {
    @Nested
    class Test2 {
        @Test
        void case1() {
            String cryptogram = "browoanoommnaon";
            String result = "brown";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case2() {
            String cryptogram = "zyelleyz";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
    }

}