package onboarding.problem1;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PageValidatorTest {

	@Test
	void page_validator() {
		PageValidator pageValidator = new PageValidator();
		assertThat(pageValidator.validate(List.of(5, 6, 7))).isFalse();
		assertThat(pageValidator.validate(List.of(5))).isFalse();

		assertThat(pageValidator.validate(List.of(1, 2))).isFalse();
		assertThat(pageValidator.validate(List.of(399, 400))).isFalse();

		assertThat(pageValidator.validate(List.of(3, 4))).isTrue();
		assertThat(pageValidator.validate(List.of(397, 398))).isTrue();
		assertThat(pageValidator.validate(List.of(97, 96))).isFalse();
		assertThat(pageValidator.validate(List.of(97, 100))).isFalse();

		assertThat(pageValidator.validate(List.of(96, 97))).isFalse();

		assertThat(pageValidator.validate(List.of(97, 98))).isTrue();
	}
}
