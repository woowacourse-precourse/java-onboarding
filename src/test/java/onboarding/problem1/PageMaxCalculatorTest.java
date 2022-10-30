package onboarding.problem1;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PageMaxCalculatorTest {

	@Test
	void pages_max_value() {
		PageMaxCalculator pageMaxCalculator = new PageMaxCalculator();
		assertThat(pageMaxCalculator.findMax(List.of(69, 169))).isEqualTo(54);
		assertThat(pageMaxCalculator.findMax(List.of(78, 169))).isEqualTo(56);
		assertThat(pageMaxCalculator.findMax(List.of(111, 11))).isEqualTo(3);
	}
}
