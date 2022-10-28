package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Problem4Test {

    @Test
    public void changeUpperCaseTest() {
        //given
        char ch1 = 'A';
        char ch2 = 'B';
        char ch3 = 'Y';
        char ch4 = 'Z';

        //when
        int result1 = Problem4.changeUpperCase(ch1);
        int result2 = Problem4.changeUpperCase(ch2);
        int result3 = Problem4.changeUpperCase(ch3);
        int result4 = Problem4.changeUpperCase(ch4);

        //then
        assertThat((char) result1).isEqualTo('Z');
        assertThat((char) result2).isEqualTo('Y');
        assertThat((char) result3).isEqualTo('B');
        assertThat((char) result4).isEqualTo('A');
    }

    @Test
    public void changeLowerCaseTest() {
        //given
        char ch1 = 'a';
        char ch2 = 'b';
        char ch3 = 'y';
        char ch4 = 'z';

        //when
        int result1 = Problem4.changeLowerCase(ch1);
        int result2 = Problem4.changeLowerCase(ch2);
        int result3 = Problem4.changeLowerCase(ch3);
        int result4 = Problem4.changeLowerCase(ch4);

        //then
        assertThat((char) result1).isEqualTo('z');
        assertThat((char) result2).isEqualTo('y');
        assertThat((char) result3).isEqualTo('b');
        assertThat((char) result4).isEqualTo('a');
    }

    @Test
    void case1() {
        String word = "Hello, World! 안녕";
        String result = "Svool, Dliow! 안녕";
        Assertions.assertThat(Problem4.solution(word)).isEqualTo(result);
    }
}