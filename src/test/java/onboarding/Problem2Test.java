package onboarding;

import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Problem2Test {

    private static StringBuilder stringBuilder;

    @BeforeEach
    void setUp() {
        stringBuilder = new StringBuilder();
        IntStream.range(0, 1000)
            .forEach(i -> stringBuilder.append("a"));
    }

    @Test
    void 정상적인_입력인_경우() {
        Assertions.assertThatCode(() -> Problem2.solution("a"));
        Assertions.assertThatCode(() -> Problem2.solution(stringBuilder.toString()));
    }

    @Test
    void 비정상적인_입력인_경우() {
        Assertions.assertThatThrownBy(() -> Problem2.solution(""));
        Assertions.assertThatThrownBy(() -> Problem2.solution("1"));
        Assertions.assertThatThrownBy(() -> Problem2.solution("a1"));
        Assertions.assertThatThrownBy(() -> Problem2.solution("aA"));

        stringBuilder.append("a");
        Assertions.assertThatThrownBy(() -> Problem2.solution(stringBuilder.toString()));
    }
}