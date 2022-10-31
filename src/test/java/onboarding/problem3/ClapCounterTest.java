package onboarding.problem3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("손벽 치는 횟수 계산기")
public class ClapCounterTest {
    @DisplayName("손벽 횟수 계산을 잘 할 수 있다")
    @Test()
    void 손벽_횟수_계산() {
        assertThat(new ClapCounter(3933).getClapCount()).isEqualTo(4);
        assertThat(new ClapCounter(2342).getClapCount()).isEqualTo(1);
        assertThat(new ClapCounter(1).getClapCount()).isEqualTo(0);
    }
}
