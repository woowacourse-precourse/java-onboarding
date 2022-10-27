package onboarding.problem2;

import onboarding.Problem2;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class cryptoGameTest {
    @Nested
    class Problem2Test {
        @Test
        void findDuplicate() {
            String cryptogram = "browoanoommnaon";
            String result = "oomm";
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
