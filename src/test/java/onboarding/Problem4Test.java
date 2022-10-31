package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem4Test {

    @Nested
    class transformAlphabet {
        
        @Test
        void basicTest() {
            assertThat((char)('Z' - ('A' - 'A'))).isEqualTo('Z');
            assertThat((char)('z' - ('b' - 'a'))).isEqualTo('y');
            assertThat((char)('Z' - ('C' - 'A'))).isEqualTo('X');
            assertThat((char)('z' - ('z' - 'a'))).isEqualTo('a');
        }

        @Test
        void case1() {
            assertThat(Problem4.transform('A')).isEqualTo('Z');
            assertThat(Problem4.transform('B')).isEqualTo('Y');
            assertThat(Problem4.transform('Y')).isEqualTo('B');
            assertThat(Problem4.transform('Z')).isEqualTo('A');

            assertThat(Problem4.transform('a')).isEqualTo('z');
            assertThat(Problem4.transform('b')).isEqualTo('y');
            assertThat(Problem4.transform('y')).isEqualTo('b');
            assertThat(Problem4.transform('z')).isEqualTo('a');
        }

        @Test
        void case2() {
            assertThat(Problem4.solution("A B Y Z")).isEqualTo("Z Y B A");
            assertThat(Problem4.solution("a b y z")).isEqualTo("z y b a");
            assertThat(Problem4.solution("I love you")).isEqualTo("R olev blf");
            assertThat(Problem4.solution("I !love yo@@u")).isEqualTo("R !olev bl@@f");
            assertThat(Problem4.solution("   I !love yo@@u   ")).isEqualTo("   R !olev bl@@f   ");
            assertThat(Problem4.solution("   I !love yo@@u 123  ")).isEqualTo("   R !olev bl@@f 123  ");
        }
    }

}