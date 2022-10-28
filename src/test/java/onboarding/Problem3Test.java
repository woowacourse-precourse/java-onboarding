package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {

    @Test
    public void makeListTest() {
        //given
        int number = 13;

        //when
        List<String> list = Problem3.makeList(number);

        //then
        assertThat(list.size()).isEqualTo(number);
        assertThat(list).containsExactly("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13");
    }

    @Test
    public void doesStringContain369Test() {
        //given
        int number = 13;
        List<String> list = Problem3.makeList(number);
        String strNotInclude369 = list.get(0);
        String strInclude369 = list.get(2);

        //when
        boolean notInclude = Problem3.doesStringContain369(strNotInclude369);
        boolean include = Problem3.doesStringContain369(strInclude369);

        //then
        assertThat(notInclude).isEqualTo(false);
        assertThat(include).isEqualTo(true);
    }

    @Test
    public void howManyStringContains369Test() {
        //given
        int number = 33;
        List<String> list = Problem3.makeList(number);
        String strIncludeOne3 = list.get(2);
        String strIncludeTwo3 = list.get(list.size() - 1);

        //when
        int couldBeOne = Problem3.howManyStringContains369(strIncludeOne3);
        int couldBeTwo = Problem3.howManyStringContains369(strIncludeTwo3);

        //then
        assertThat(strIncludeOne3).isEqualTo("3");
        assertThat(strIncludeTwo3).isEqualTo("33");
        assertThat(couldBeOne).isEqualTo(1);
        assertThat(couldBeTwo).isEqualTo(2);
    }

    @Test
    public void solutionTest() {
        //given
        int testNumber1 = 13;
        int testNumber2 = 33;
        int testNumber3 = 40;

        //when
        int result1 = Problem3.solution(testNumber1);
        int result2 = Problem3.solution(testNumber2);
        int result3 = Problem3.solution(testNumber3);

        //then
        assertThat(result1).isEqualTo(4);
        assertThat(result2).isEqualTo(14);
        assertThat(result3).isEqualTo(22);
    }
}