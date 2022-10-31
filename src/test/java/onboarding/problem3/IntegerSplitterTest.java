package onboarding.problem3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("숫자 쪼개기")
public class IntegerSplitterTest {
    @DisplayName("숫자가 잘 쪼개짐")
    @Test
    void 숫자_쪼개기() {
        assertThat(new IntegerSplitter(234).getSplitList()).isEqualTo(List.of(2, 3, 4));
    }
}
