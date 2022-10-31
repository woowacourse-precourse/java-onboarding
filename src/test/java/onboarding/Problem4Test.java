package onboarding;

import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Problem4Test {

    private final StringBuilder stringBuilder = new StringBuilder();

    @BeforeEach
    void setUp() {
        IntStream.range(0, 1000)
            .forEach(i -> stringBuilder.append("0"));
    }

    @Test
    void 정상적인_입력인_경우() {
        Assertions.assertThatCode(() -> Problem4.solution("1"))
            .doesNotThrowAnyException();

        Assertions.assertThatCode(() -> Problem4.solution(stringBuilder.toString()))
            .doesNotThrowAnyException();
    }

    @Test
    void 비정상적인_입력인_경우() {
        Assertions.assertThatThrownBy(() -> Problem4.solution(""));

        stringBuilder.append("a");
        Assertions.assertThatThrownBy(() -> Problem4.solution(stringBuilder.toString()));
    }

    @Test
    void 테스트케이스() {
        Assertions.assertThat(Problem4.solution("Hello  Everyone!"))
            .isEqualTo("Svool  Veviblmv!");
        Assertions.assertThat(Problem4.solution("abcdefghijklmnopqrstuvwxyz"))
            .isEqualTo("zyxwvutsrqponmlkjihgfedcba");
        Assertions.assertThat(Problem4.solution("abcdefghijklmnopqrstuvwxyz !@#!#  "))
            .isEqualTo("zyxwvutsrqponmlkjihgfedcba !@#!#  ");
        Assertions.assertThat(Problem4.solution("Svool, Dliow! 123"))
            .isEqualTo("Hello, World! 123");
    }
}