package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class Problem2Test {
    Problem2 problem = new Problem2();

    @Test
    @DisplayName("String Length Test")
    void strLen() {
        assertThat(problem.strLenException("l")).isEqualTo(false);
        assertThat(problem.strLenException("")).isEqualTo(true);
    }

}
