package onboarding;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TestProblem4 {
    @Test
    void TestisUpper(){
        assertThat(Problem4.isUpper('A')).isEqualTo(true);
        assertThat(Problem4.isUpper('a')).isEqualTo(false);
        assertThat(Problem4.isUpper('Z')).isEqualTo(true);
    }

    @Test
    void TestisLower(){
        assertThat(Problem4.isLower('A')).isEqualTo(false);
        assertThat(Problem4.isLower('a')).isEqualTo(true);
        assertThat(Problem4.isLower('Z')).isEqualTo(false);
    }

    @Test
    void TesttranslateUpper(){
        assertThat(Problem4.translateUpper('A')).isEqualTo('Z');
        assertThat(Problem4.translateUpper('Z')).isEqualTo('A');
        assertThat(Problem4.translateUpper('K')).isEqualTo('P');
    }

    @Test
    void TesttranslateLower(){
        assertThat(Problem4.translateLower('a')).isEqualTo('z');
        assertThat(Problem4.translateLower('z')).isEqualTo('a');
        assertThat(Problem4.translateLower('k')).isEqualTo('p');
    }

    @Test
    void TestSolution(){
        assertThat(Problem4.solution("abcd1234")).isEqualTo("zyxw1234");
    }
}
