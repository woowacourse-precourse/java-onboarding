package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

class Problem2Test {

    @Nested
    class LogicTest {

        @Test
        @DisplayName("모두 없어지는 경우")
        void case1() {
            assertThat(Problem2.solution("zyelleyz")).isEqualTo("");
            assertThat(Problem2.solution("aabbccddeeeee")).isEqualTo("");
            assertThat(Problem2.solution("aaaaa")).isEqualTo("");
        }

        @Test
        @DisplayName("모두 없어지지 않는 경우")
        void case2() {
            assertThat(Problem2.solution("browoanoommnaon")).isEqualTo("brown");
        }

        @Test
        @DisplayName("결과가 그대로")
        void case3() {
            assertThat(Problem2.solution("abcdef")).isEqualTo("abcdef");
            assertThat(Problem2.solution("a")).isEqualTo("a");
            assertThat(Problem2.solution("aba")).isEqualTo("aba");
        }
    }
}