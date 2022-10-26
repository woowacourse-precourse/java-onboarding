package onboarding.pagenumbergame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {

	@DisplayName("페이지 숫자 검증")
	@Test
	void 페이지_숫자_검증() {
		assertThat(ValidationUtils.validateNumber(1)).isFalse();
		assertThat(ValidationUtils.validateNumber(400)).isFalse();
		assertThat(ValidationUtils.validateNumber(2)).isTrue();
		assertThat(ValidationUtils.validateNumber(5)).isTrue();
	}
}
