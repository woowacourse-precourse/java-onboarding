package problem5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BankTest {

    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
    }

    @Test
    void _50000원권_환전() {
        int result = bank.changeMoneyTo(50237, 50000);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void _10000원권_환전() {
        int result = bank.changeMoneyTo(50237, 10000);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void _5000원권_환전() {
        int result = bank.changeMoneyTo(15000, 5000);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void _1000원권_환전() {
        int result = bank.changeMoneyTo(15000, 1000);
        assertThat(result).isEqualTo(15);
    }

    @Test
    void _500원권_환전() {
        int result = bank.changeMoneyTo(1000, 500);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void _100원권_환전() {
        int result = bank.changeMoneyTo(1000, 100);
        assertThat(result).isEqualTo(10);
    }

    @Test
    void _50원권_환전() {
        int result = bank.changeMoneyTo(150, 50);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void _10원권_환전() {
        int result = bank.changeMoneyTo(50, 10);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void _1원권_환전() {
        int result = bank.changeMoneyTo(13, 1);
        assertThat(result).isEqualTo(13);
    }

    @Test
    void 큰금액_위주로환전_결과() {
        List<Integer> result1 =  bank.changeAllMoney(50237);
        List<Integer> result2 = bank.changeAllMoney(15000);

        assertThat(result1).containsExactly(1, 0, 0, 0, 0, 2, 0, 3, 7);
        assertThat(result2).containsExactly(0, 1, 1, 0, 0, 0, 0, 0, 0);
    }
}
