package onboarding;

import org.junit.jupiter.api.Test;

import static onboarding.Problem4.*;
import static org.assertj.core.api.Assertions.assertThat;

class Problem4MethodTest {

    @Test
    void transformCharTest() {
        char c1 = 'X';
        char c2 = 'h';
        char c3 = ' ';

        char result1 = transformChar(c1);
        char result2 = transformChar(c2);
        char result3 = transformChar(c3);

        assertThat(result1).isEqualTo('C');
        assertThat(result2).isEqualTo('s');
        assertThat(result3).isEqualTo(' ');
    }

    @Test
    void transformUpperTest() {
        char c1 = 'X';
        char c2 = 'H';

        char result1 = transformUpper(c1);
        char result2 = transformUpper(c2);

        assertThat(result1).isEqualTo('C');
        assertThat(result2).isEqualTo('S');
    }

    @Test
    void transformLowerTest() {
        char c1 = 'x';
        char c2 = 'h';

        char result1 = transformLower(c1);
        char result2 = transformLower(c2);

        assertThat(result1).isEqualTo('c');
        assertThat(result2).isEqualTo('s');
    }

    @Test
    void isUpperTest() {
        char c1 = 'X';
        char c2 = 'a';

        boolean result1 = isUpper(c1);
        boolean result2 = isUpper(c2);

        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(false);
    }

    @Test
    void isLowerTest() {
        char c1 = 'x';
        char c2 = 'A';

        boolean result1 = isLower(c1);
        boolean result2 = isLower(c2);

        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(false);
    }

    @Test
    void isAlphaTest() {
        char c1 = 'X';
        char c2 = 'a';
        char c3 = ' ';

        boolean result1 = isAlpha(c1);
        boolean result2 = isAlpha(c2);
        boolean result3 = isAlpha(c3);

        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(true);
        assertThat(result3).isEqualTo(false);
    }
}