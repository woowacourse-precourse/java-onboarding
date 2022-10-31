package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem5Test {

    @Test
    public void makeMoneyTypesTest() {
        //given
        List<Integer> result = List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);

        //when
        List<Integer> moneyType = Problem5.makeMoneyTypes();

        //then
        System.out.println("moneyType = " + moneyType);
        assertThat(result).isEqualTo(moneyType);
    }

    @Test
    public void getMoneyIngredientsTest() {
        //given
        int money = 50237;
        List<Integer> moneyTypes = Problem5.makeMoneyTypes();

        //when
        List<Integer> result = Problem5.getMoneyIngredients(money, moneyTypes);

        //then
        assertThat(result).containsExactly(1, 0, 0, 0, 0, 2, 0, 3, 7);
    }

    @Test
    public void getMoneyIngredientsTest2() {
        //given
        int money = 15000;
        List<Integer> moneyTypes = Problem5.makeMoneyTypes();

        //when
        List<Integer> result = Problem5.getMoneyIngredients(money, moneyTypes);

        //then
        assertThat(result).containsExactly(0, 1, 1, 0, 0, 0, 0, 0, 0);
    }

    @Test
    void case1() {
        int money = 66_661;
        List<Integer> result = List.of(1, 1, 1, 1, 1, 1, 1, 1, 1);
        assertThat(Problem5.solution(money)).isEqualTo(result);
    }
}