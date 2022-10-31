package onboarding.problem5;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CoinCalculatorTest {

	@Test
	void coin_calculate_quantity() {
		CoinCalculator coinCalculator = new CoinCalculator();
		assertThat(coinCalculator.calculatorCoinQuantity(1000, 50)).isEqualTo(20);
		assertThat(coinCalculator.calculatorCoinQuantity(1020, 50)).isEqualTo(20);
	}

	@Test
	void coin_calculate_rest() {
		CoinCalculator coinCalculator = new CoinCalculator();
		assertThat(coinCalculator.calculatorCoinRest(1000, 50)).isEqualTo(0);
		assertThat(coinCalculator.calculatorCoinRest(1020, 50)).isEqualTo(20);
	}
}
