package onboarding.problem1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PageMultiplyCalculatorTest {

	@Test
	void page_multiply() {
		PageMultiplyCalculator pageMultiplyCalculator = new PageMultiplyCalculator();
		assertThat(pageMultiplyCalculator.calculate(96)).isEqualTo(54);
		assertThat(pageMultiplyCalculator.calculate(126)).isEqualTo(12);
	}
}
