package onboarding.problem1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PagePlusCalculatorTest {

	@Test
	void page_plus_sum() {
		PagePlusCalculator pagePlusCalculator = new PagePlusCalculator();
		Assertions.assertThat(pagePlusCalculator.calculate(96)).isEqualTo(15);
		Assertions.assertThat(pagePlusCalculator.calculate(94)).isEqualTo(13);
	}
}
