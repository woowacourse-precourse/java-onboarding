package onboarding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem4Test {
    @Test
    void test() {
        assertThat((char)('Z' - ('A' - 'A'))).isEqualTo('Z');
        assertThat((char)('Z' - ('B' - 'A'))).isEqualTo('Y');
        assertThat((char)('Z' - ('C' - 'A'))).isEqualTo('X');
        assertThat((char)('Z' - ('Z' - 'A'))).isEqualTo('A');
    }
}