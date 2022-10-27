package onboarding;

import org.junit.jupiter.api.Test;
import utils.Problem4Util;

import static org.assertj.core.api.Assertions.assertThat;

class Problem4Test {
    @Test
    void charChageTest() {
        assertThat(Problem4Util.transform('A')).isEqualTo('Z');
        assertThat(Problem4Util.transform('a')).isEqualTo('z');
        assertThat(Problem4Util.transform('B')).isEqualTo('Y');
        assertThat(Problem4Util.transform('C')).isEqualTo('X');
        assertThat(Problem4Util.transform('Y')).isEqualTo('B');
        assertThat(Problem4Util.transform('Z')).isEqualTo('A');
        assertThat(Problem4Util.transform('O')).isEqualTo('L');
        assertThat(Problem4Util.transform('o')).isEqualTo('l');
    }

    @Test
    void test() {
        assertThat((char)('Z' - ('A' - 'A'))).isEqualTo('Z');
        assertThat((char)('Z' - ('B' - 'A'))).isEqualTo('Y');
        assertThat((char)('Z' - ('C' - 'A'))).isEqualTo('X');
        assertThat((char)('Z' - ('Z' - 'A'))).isEqualTo('A');
    }
}