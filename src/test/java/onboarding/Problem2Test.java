package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문제 2 테스트")
class Problem2Test {
    @DisplayName("연속하는 중복 문자들을 삭제한다.")
    @ValueSource(strings = {"aaaaabbbaaaaaa", "bbbbaaabbb", "aaaa"})
    @ParameterizedTest
    void solution(String cryptogram) {
        String result = Problem2.solution(cryptogram);

        assertThat(result).isEmpty();
    }
}
