package onboarding.problem1;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PageTypeValidatorTest {

	@Test
	@DisplayName("연속된 숫자 확인기능")
	void page_type() {
		PageTypeValidator pageTypeValidator = new PageTypeValidator();
		assertThat(pageTypeValidator.validate(List.of(97, 96))).isFalse();
		assertThat(pageTypeValidator.validate(List.of(97, 100))).isFalse();

		assertThat(pageTypeValidator.validate(List.of(96, 97))).isFalse();

		assertThat(pageTypeValidator.validate(List.of(97, 98))).isTrue();
	}
}
