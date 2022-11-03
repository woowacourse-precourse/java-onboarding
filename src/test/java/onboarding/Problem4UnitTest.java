package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem4UnitTest {

    @Test
    public void findOppositeLetterTest() {

        // given
        int test1 = 'k';
        int test2 = 'T';
        int test3 = 'o';
        int test4 = 'a';
        int test5 = 'M';
        int test6 = 's';
        int test7 = 'X';
        int test8 = 'n';
        int test9 = ' ';
        int test10 = '.';

        // when
        Character result1 = Problem4.findOppositeLetter(test1);
        Character result2 = Problem4.findOppositeLetter(test2);
        Character result3 = Problem4.findOppositeLetter(test3);
        Character result4 = Problem4.findOppositeLetter(test4);
        Character result5 = Problem4.findOppositeLetter(test5);
        Character result6 = Problem4.findOppositeLetter(test6);
        Character result7 = Problem4.findOppositeLetter(test7);
        Character result8 = Problem4.findOppositeLetter(test8);
        Character result9 = Problem4.findOppositeLetter(test9);
        Character result10 = Problem4.findOppositeLetter(test10);


        // then
        Assertions.assertThat(result1).isEqualTo('p');
        Assertions.assertThat(result2).isEqualTo('G');
        Assertions.assertThat(result3).isEqualTo('l');
        Assertions.assertThat(result4).isEqualTo('z');
        Assertions.assertThat(result5).isEqualTo('N');
        Assertions.assertThat(result6).isEqualTo('h');
        Assertions.assertThat(result7).isEqualTo('C');
        Assertions.assertThat(result8).isEqualTo('m');
        Assertions.assertThat(result9).isEqualTo(' ');
        Assertions.assertThat(result10).isEqualTo('.');




    }
}
