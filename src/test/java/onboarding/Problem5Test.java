package onboarding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class Problem5Test {

    static final List<Integer> entry = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    List<Integer> result;

    @Test
    void moneyFormatTest() {
        int money = 13_500;
        assertThat(money).isEqualTo(13500);
    }

    @BeforeEach
    void init() {
        result = new ArrayList<>();
        initAnswer(result);
    }

    @Nested
    class LogicTest {
        @Test
        void case1() {
            int money = 50_237;
            getAnswer(money, result);
            assertThat(result).isEqualTo(List.of(1, 0, 0, 0, 0, 2, 0, 3, 7));
        }

        @Test
        void case2() {
            int money = 15_000;
            getAnswer(money, result);
            assertThat(result).isEqualTo(List.of(0, 1, 1, 0, 0, 0, 0, 0, 0));
        }

        @Test
        void case3() {
            int money = 1;
            getAnswer(money, result);
            assertThat(result).isEqualTo(List.of(0, 0, 0, 0, 0, 0, 0, 0, 1));
        }
        @Test
        void case4() {
            int money = 1000000;
            getAnswer(money, result);
            assertThat(result).isEqualTo(List.of(20, 0, 0, 0, 0, 0, 0, 0, 0));
        }
    }


    private static void initAnswer(List<Integer> answer) {
        for (int i = 0; i < entry.size(); i++) {
            answer.add(0);
        }
    }

    private static void getAnswer(int money, List<Integer> answer) {
        int idx = 0;
        while (money > 0) {
            money = makeResult(money, answer, idx++);
        }
    }

    private static int makeResult(int money, List<Integer> answer, int idx) {
        Integer targetBill = entry.get(idx);
        int operateResult = money / targetBill;

        if (operateResult > 0) {
            answer.set(idx, answer.get(idx) + operateResult);
            return money - (targetBill * operateResult);
        }
        return money;
    }
}