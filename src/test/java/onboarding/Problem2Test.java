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

    @Test
    void duplicateRemove() {
        Assertions.assertThat(Problem2.duplicateRemove("acbbceecccd"))
            .isEqualTo("accd");
        Assertions.assertThat(Problem2.duplicateRemove("acbbceecccdd"))
            .isEqualTo("acc");
        Assertions.assertThat(Problem2.duplicateRemove("acbbceecd"))
            .isEqualTo("acccd");
        Assertions.assertThat(Problem2.duplicateRemove("aabb"))
            .isEqualTo("");
        Assertions.assertThat(Problem2.duplicateRemove("aacbb"))
            .isEqualTo("c");
        Assertions.assertThat(Problem2.duplicateRemove("aaacbb"))
            .isEqualTo("c");
        Assertions.assertThat(Problem2.duplicateRemove("aaacbbd"))
            .isEqualTo("cd");
        Assertions.assertThat(Problem2.duplicateRemove("aaacbbdd"))
            .isEqualTo("c");
    }

    @Test
    void 테스트케이스() {
        Assertions.assertThat(Problem2.solution("baaaoat"))
            .isEqualTo("boat");
        Assertions.assertThat(Problem2.solution("acbbceecccd"))
            .isEqualTo("ad");
        Assertions.assertThat(Problem2.solution("acbbceecd"))
            .isEqualTo("ad");
        Assertions.assertThat(Problem2.solution("aabb"))
            .isEqualTo("");
        Assertions.assertThat(Problem2.solution("aaacbb"))
            .isEqualTo("c");
        Assertions.assertThat(Problem2.solution("aaacbbd"))
            .isEqualTo("cd");
        Assertions.assertThat(Problem2.solution("aaacbbdd"))
            .isEqualTo("c");
        Assertions.assertThat(Problem2.solution("zyellleyz"))
            .isEqualTo("");
        Assertions.assertThat(Problem2.solution("zyalllelyz"))
            .isEqualTo("zyaelyz");
        Assertions.assertThat(Problem2.solution("aabba"))
            .isEqualTo("a");
        Assertions.assertThat(Problem2.solution("abbaa"))
            .isEqualTo("a");
        Assertions.assertThat(Problem2.solution("aazzqweqweaaq"))
            .isEqualTo("qweqweq");
        Assertions.assertThat(Problem2.solution("ksekkset"))
            .isEqualTo("kseset");
        Assertions.assertThat(Problem2.solution("ksekkset"))
            .isEqualTo("kseset");
    }
}
