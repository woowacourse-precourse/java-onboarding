package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem1Test {
    Problem1 problem = new Problem1();
    @Test
    @DisplayName("List Size Test")
    void listSize() {
        List<Integer> list = List.of(197, 198, 199);
        boolean result = true;
        assertThat(problem.listException(list)).isEqualTo(result);
    }
}
