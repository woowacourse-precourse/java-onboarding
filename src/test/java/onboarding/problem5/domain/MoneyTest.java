package onboarding.problem5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {
    @Test
    @DisplayName("각 화폐 개수 구하기")
    void numberOfEachCurrency() {
        Money money = new Money(50237);
        List<Integer> numberOfEachCurrency = money.numberOfEachCurrency();
        assertThat(numberOfEachCurrency).isEqualTo(Arrays.asList(1, 0, 0, 0, 0, 2, 0, 3, 7));
    }
}
