package problem5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    void _50000만원권_환전() {
        Bank bank = new Bank();
        int result = bank.changeMoneyTo(50237, 50000);
        Assertions.assertThat(result).isEqualTo(1);
    }
}
