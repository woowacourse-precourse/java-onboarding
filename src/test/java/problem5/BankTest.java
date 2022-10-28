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
}
