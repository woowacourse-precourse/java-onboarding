package onboarding;

import org.junit.jupiter.api.Test;
import utils.Problem4Util;

import static org.assertj.core.api.Assertions.assertThat;

class Problem4Test {
    @Test
    void charChageTest() {
        assertThat(Problem4Util.transform('A')).isEqualTo('Z');
        assertThat(Problem4Util.transform('B')).isEqualTo('Y');
        assertThat(Problem4Util.transform('C')).isEqualTo('X');
        assertThat(Problem4Util.transform('Y')).isEqualTo('B');
        assertThat(Problem4Util.transform('Z')).isEqualTo('A');
    }
}