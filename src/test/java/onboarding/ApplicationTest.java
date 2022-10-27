package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {

    @Nested
    class Problem2Test {
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

        @Test
        void case3() {
            String cryptogram = "cbbccd";
            String result = "cd";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case4() {
            String cryptogram = "aaaaaaaaabbbbbbbbbdddddddd";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
    }

}
