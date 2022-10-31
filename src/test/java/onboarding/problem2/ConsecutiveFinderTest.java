package onboarding.problem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("연속된 중복 문자 탐색기")
public class ConsecutiveFinderTest {
    private final StringBuilder 처리할_부분이_남은_문자열 = new StringBuilder("hello");

    @DisplayName("탐색할 부분이 남았는지 체크")
    @Test
    void 남은_부분_체크() {
        assertThat(new ConsecutiveFinder(처리할_부분이_남은_문자열).isRemained(5)).isEqualTo(false);
        assertThat(new ConsecutiveFinder(처리할_부분이_남은_문자열).isRemained(4)).isEqualTo(true);
    }

    @DisplayName("index부터 지워야 할 index를 반환함")
    @Test
    void 다음_index_반환() {
        ConsecutiveFinder consecutiveFinder = new ConsecutiveFinder(처리할_부분이_남은_문자열);
        assertThat(consecutiveFinder.findConsequence(3)).isEqualTo(2);
        assertThat(consecutiveFinder.findConsequence(2)).isEqualTo(2);
        assertThat(consecutiveFinder.findConsequence(0)).isEqualTo(0);
        assertThat(consecutiveFinder.findConsequence(4)).isEqualTo(4);

    }
}
