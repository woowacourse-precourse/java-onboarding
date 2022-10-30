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
}