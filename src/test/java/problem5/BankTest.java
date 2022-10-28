package problem5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BankTest {

    @Test
    void _50000원권_환전() {
        Bank bank = new Bank();
        int result = bank.changeMoneyTo(50237, 50000);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void _10000원권_환전() {
        Bank bank = new Bank();
        int result = bank.changeMoneyTo(50237, 10000);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void _5000원권_환전() {
        Bank bank = new Bank();
        int result = bank.changeMoneyTo(15000, 5000);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void _1000원권_환전() {
        Bank bank = new Bank();
        int result = bank.changeMoneyTo(15000, 1000);
        assertThat(result).isEqualTo(15);
    }

    @Test
    void _500원권_환전() {
        Bank bank = new Bank();
        int result = bank.changeMoneyTo(1000, 500);
        assertThat(result).isEqualTo(2);
    }
}
