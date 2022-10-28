package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

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
}