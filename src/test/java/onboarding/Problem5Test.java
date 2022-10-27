package onboarding;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class Problem5Test {

    static List<Integer> list = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);


    @Test
    void moneyInputTest() {
        int money = 13_500;
        assertThat(money).isEqualTo(13500);
    }

    @Test
    void logic() {
        int money = 50_237;
        List<Integer> result = new ArrayList<>();
        int idx = 0;
        while (money > 0) {
            Integer targetBill = list.get(idx++);
            money = makeResult(money, result, targetBill);
        }
        List<Integer> answer = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
        assertThat(result).isEqualTo(answer);
    }

    private int makeResult(int money, List<Integer> result, Integer el) {
        int operateResult = money / el;
        if (operateResult > 0) {
            result.add(operateResult);
            return money - (el * operateResult);
        }
        result.add(0);
        return money;
    }
}