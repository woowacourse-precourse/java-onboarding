package onboarding.problem1;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PageRangeValidatorTest {

	@Test
	void page_range() {
		PageRangeValidator pageRangeValidator = new PageRangeValidator();
		assertThat(pageRangeValidator.validate(List.of(5, 6, 7))).isFalse();
		assertThat(pageRangeValidator.validate(List.of(5))).isFalse();

		assertThat(pageRangeValidator.validate(List.of(1, 2))).isFalse();
		assertThat(pageRangeValidator.validate(List.of(399, 400))).isFalse();

		assertThat(pageRangeValidator.validate(List.of(3, 4))).isTrue();
		assertThat(pageRangeValidator.validate(List.of(397, 398))).isTrue();
	}
}
