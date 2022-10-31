package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {

    @Test
    public void getCryptogramIngredientsTest() {
        //given
        String cryptogram1 = "browoanoommnaon";
        String cryptogram2 = "zyelleyz";

        //when
        List<String> cryptogramIngredients1 = Problem2.getCryptogramIngredients(cryptogram1);
        List<String> cryptogramIngredients2 = Problem2.getCryptogramIngredients(cryptogram2);

        //then
        assertThat(cryptogramIngredients1).containsExactly("b", "r", "o", "w", "o", "a", "n", "o", "o", "m", "m", "n", "a", "o", "n");
        assertThat(cryptogramIngredients2).containsExactly("z", "y", "e", "l", "l", "e", "y", "z");
    }

    @Test
    public void getDuplicatedCharIndexTest() {
        //given
        String cryptogram1 = "browoanoommnaon";
        String cryptogram2 = "browoannaon";
        String cryptogram3 = "browoaaon";
        String cryptogram4 = "browoon";
        String cryptogram5 = "brown";
        List<String> cryptogramIngredients1 = Problem2.getCryptogramIngredients(cryptogram1);
        List<String> cryptogramIngredients2 = Problem2.getCryptogramIngredients(cryptogram2);
        List<String> cryptogramIngredients3 = Problem2.getCryptogramIngredients(cryptogram3);
        List<String> cryptogramIngredients4 = Problem2.getCryptogramIngredients(cryptogram4);
        List<String> cryptogramIngredients5 = Problem2.getCryptogramIngredients(cryptogram5);

        //when
        Set<Integer> duplicatedCharIndex1 = Problem2.getDuplicatedCharIndex(cryptogramIngredients1);
        Set<Integer> duplicatedCharIndex2 = Problem2.getDuplicatedCharIndex(cryptogramIngredients2);
        Set<Integer> duplicatedCharIndex3 = Problem2.getDuplicatedCharIndex(cryptogramIngredients3);
        Set<Integer> duplicatedCharIndex4 = Problem2.getDuplicatedCharIndex(cryptogramIngredients4);
        Set<Integer> duplicatedCharIndex5 = Problem2.getDuplicatedCharIndex(cryptogramIngredients5);

        //then
        assertThat(duplicatedCharIndex1).containsExactly(7, 8, 9, 10);
        assertThat(duplicatedCharIndex2).containsExactly(6, 7);
        assertThat(duplicatedCharIndex3).containsExactly(5, 6);
        assertThat(duplicatedCharIndex4).containsExactly(4, 5);
        assertThat(duplicatedCharIndex5).isEmpty();
    }

    @Test
    public void setToListWithReverseOrderTest() {
        //given
        String cryptogram1 = "browoanoommnaon";
        String cryptogram2 = "browoannaon";
        String cryptogram3 = "browoaaon";
        String cryptogram4 = "browoon";
        String cryptogram5 = "brown";
        List<String> cryptogramIngredients1 = Problem2.getCryptogramIngredients(cryptogram1);
        List<String> cryptogramIngredients2 = Problem2.getCryptogramIngredients(cryptogram2);
        List<String> cryptogramIngredients3 = Problem2.getCryptogramIngredients(cryptogram3);
        List<String> cryptogramIngredients4 = Problem2.getCryptogramIngredients(cryptogram4);
        List<String> cryptogramIngredients5 = Problem2.getCryptogramIngredients(cryptogram5);
        Set<Integer> duplicatedCharIndex1 = Problem2.getDuplicatedCharIndex(cryptogramIngredients1);
        Set<Integer> duplicatedCharIndex2 = Problem2.getDuplicatedCharIndex(cryptogramIngredients2);
        Set<Integer> duplicatedCharIndex3 = Problem2.getDuplicatedCharIndex(cryptogramIngredients3);
        Set<Integer> duplicatedCharIndex4 = Problem2.getDuplicatedCharIndex(cryptogramIngredients4);
        Set<Integer> duplicatedCharIndex5 = Problem2.getDuplicatedCharIndex(cryptogramIngredients5);

        //when
        List<Integer> duplicatedCharIndexReverseOrder1 = Problem2.setToListWithReverseOrder(duplicatedCharIndex1);
        List<Integer> duplicatedCharIndexReverseOrder2 = Problem2.setToListWithReverseOrder(duplicatedCharIndex2);
        List<Integer> duplicatedCharIndexReverseOrder3 = Problem2.setToListWithReverseOrder(duplicatedCharIndex3);
        List<Integer> duplicatedCharIndexReverseOrder4 = Problem2.setToListWithReverseOrder(duplicatedCharIndex4);
        List<Integer> duplicatedCharIndexReverseOrder5 = Problem2.setToListWithReverseOrder(duplicatedCharIndex5);

        //then
        assertThat(duplicatedCharIndexReverseOrder1).containsExactly(10, 9, 8, 7);
        assertThat(duplicatedCharIndexReverseOrder2).containsExactly(7, 6);
        assertThat(duplicatedCharIndexReverseOrder3).containsExactly(6, 5);
        assertThat(duplicatedCharIndexReverseOrder4).containsExactly(5, 4);
        assertThat(duplicatedCharIndexReverseOrder5).isEmpty();
    }

    @Test
    public void listToStringTest() {
        //given
        String cryptogram = "browoanoommnaon";
        List<String> cryptogramIngredients = Problem2.getCryptogramIngredients(cryptogram);

        //when
        String result = Problem2.listToString(cryptogramIngredients);

        //then
        assertThat(result).isEqualTo(cryptogram);
    }

    @Test
    void case1() {
        String cryptogram = "sadddaaaas";
        String result = "sas";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void case2() {
        String cryptogram = "baaaoat";
        String result = "boat";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }
}