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
}