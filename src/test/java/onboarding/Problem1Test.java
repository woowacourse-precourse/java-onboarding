package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

import static onboarding.Problem1.*;
import static onboarding.Problem1.getPageIngredients;
import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {

    @Test
    public void validatePageTest() {
        // given
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);

        // when
        boolean checkPobiNumber = validatePage(pobi);
        boolean checkCrongNumber = validatePage(crong);

        // then
        assertThat(checkPobiNumber).isEqualTo(true);
        assertThat(checkCrongNumber).isEqualTo(true);
    }

    @Test
    public void validatePageFailTest() {
        // given
        List<Integer> pobi = List.of(99, 102);
        List<Integer> crong = List.of(211, 212);
        List<Integer> james = List.of(0, 1);
        List<Integer> mac = List.of(401, 402);

        // when
        boolean checkPobiNumber = validatePage(pobi);
        boolean checkCrongNumber = validatePage(crong);
        boolean checkJamesNumber = validatePage(james);
        boolean checkMacNumber = validatePage(mac);

        // then
        assertThat(checkPobiNumber).isEqualTo(false);
        assertThat(checkCrongNumber).isEqualTo(true);
        assertThat(checkJamesNumber).isEqualTo(false);
        assertThat(checkMacNumber).isEqualTo(false);
    }

    @Test
    public void getPageLengthTest() {
        //given
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);

        //when
        int pobiFirstPageLength = getPageLength(pobi.get(0));
        int pobiSecondPageLength = getPageLength(pobi.get(1));
        int crongFirstPageLength = getPageLength(crong.get(0));
        int crongSecondPageLength = getPageLength(crong.get(1));

        //then
        assertThat(pobiFirstPageLength).isEqualTo(2);
        assertThat(pobiSecondPageLength).isEqualTo(2);
        assertThat(crongFirstPageLength).isEqualTo(3);
        assertThat(crongSecondPageLength).isEqualTo(3);
    }

    @Test
    public void getPageIngredientsTest() {
        //given
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);

        //when
        List<Integer> pobiFirstPageIngredient = getPageIngredients(pobi.get(0));
        List<Integer> pobiSecondPageIngredient = getPageIngredients(pobi.get(1));
        List<Integer> crongFirstPageIngredient = getPageIngredients(crong.get(0));
        List<Integer> crongSecondPageIngredient = getPageIngredients(crong.get(1));

        //then
        assertThat(pobiFirstPageIngredient).containsExactly(7, 9);
        assertThat(pobiSecondPageIngredient).containsExactly(8, 9);
        assertThat(crongFirstPageIngredient).containsExactly(7, 9, 1);
        assertThat(crongSecondPageIngredient).containsExactly(8, 9, 1);
    }

    @Test
    public void sumPageIngredientTest() {
        //given
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);

        List<Integer> pobiFirstPageIngredient = getPageIngredients(pobi.get(0));
        List<Integer> pobiSecondPageIngredient = getPageIngredients(pobi.get(1));
        List<Integer> crongFirstPageIngredient = getPageIngredients(crong.get(0));
        List<Integer> crongSecondPageIngredient = getPageIngredients(crong.get(1));

        //when
        int pobiFirstPageIngredientSum = sumPageIngredient(pobiFirstPageIngredient);
        int pobiSecondPageIngredientSum = sumPageIngredient(pobiSecondPageIngredient);
        int crongFirstPageIngredientSum = sumPageIngredient(crongFirstPageIngredient);
        int crongSecondPageIngredientSum = sumPageIngredient(crongSecondPageIngredient);

        //then
        assertThat(pobiFirstPageIngredientSum).isEqualTo(16);
        assertThat(pobiSecondPageIngredientSum).isEqualTo(17);
        assertThat(crongFirstPageIngredientSum).isEqualTo(17);
        assertThat(crongSecondPageIngredientSum).isEqualTo(18);
    }

    @Test
    public void multiplyPageIngredient() {
        //given
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);

        List<Integer> pobiFirstPageIngredient = getPageIngredients(pobi.get(0));
        List<Integer> pobiSecondPageIngredient = getPageIngredients(pobi.get(1));
        List<Integer> crongFirstPageIngredient = getPageIngredients(crong.get(0));
        List<Integer> crongSecondPageIngredient = getPageIngredients(crong.get(1));

        //when
        int pobiFirstPageIngredientMultiply = Problem1.multiplyPageIngredient(pobiFirstPageIngredient);
        int pobiSecondPageIngredientMultiply = Problem1.multiplyPageIngredient(pobiSecondPageIngredient);
        int crongFirstPageIngredientMultiply = Problem1.multiplyPageIngredient(crongFirstPageIngredient);
        int crongSecondPageIngredientMultiply = Problem1.multiplyPageIngredient(crongSecondPageIngredient);

        //then
        assertThat(pobiFirstPageIngredientMultiply).isEqualTo(63);
        assertThat(pobiSecondPageIngredientMultiply).isEqualTo(72);
        assertThat(crongFirstPageIngredientMultiply).isEqualTo(63);
        assertThat(crongSecondPageIngredientMultiply).isEqualTo(72);
    }
}