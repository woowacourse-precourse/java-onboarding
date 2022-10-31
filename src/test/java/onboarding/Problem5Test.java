package onboarding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class Problem5Test {

    List<Integer> result;

    @Test
    void moneyFormatTest() {
        int money = 13_500;
        assertThat(money).isEqualTo(13500);
    }

    @BeforeEach
    void init() {
        result = Problem5.initAnswer();
    }

    @Nested
    class LogicTest {
        @Test
        void case1() {
            Problem5.getAnswer(50_237, result);
            assertThat(result).isEqualTo(List.of(1, 0, 0, 0, 0, 2, 0, 3, 7));
        }

        @Test
        void case2() {
            Problem5.getAnswer(15_000, result);
            assertThat(result).isEqualTo(List.of(0, 1, 1, 0, 0, 0, 0, 0, 0));
        }

        @Test
        void case3() {
            Problem5.getAnswer(1, result);
            assertThat(result).isEqualTo(List.of(0, 0, 0, 0, 0, 0, 0, 0, 1));
        }

        @Test
        void case4() {
            Problem5.getAnswer(1000000, result);
            assertThat(result).isEqualTo(List.of(20, 0, 0, 0, 0, 0, 0, 0, 0));
        }
    }
}