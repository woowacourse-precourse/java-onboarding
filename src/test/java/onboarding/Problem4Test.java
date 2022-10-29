package onboarding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Problem4Test {

    private Problem4 problem4;

    @BeforeEach
    void setUp() {
        problem4 = new Problem4();
    }

    @Test
    void isUpperCaseTest() {
        int capitalLetterAsciiCode = 67;
        assertThat(problem4.isUpperCase(capitalLetterAsciiCode)).isEqualTo(true);

        int otherAsciiCode = 91;
        assertThat(problem4.isUpperCase(otherAsciiCode)).isNotEqualTo(true);
    }
}