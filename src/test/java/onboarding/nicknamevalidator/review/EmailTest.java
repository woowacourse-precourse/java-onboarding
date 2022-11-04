package onboarding.nicknamevalidator.review;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(
	DisplayNameGenerator.ReplaceUnderscores.class
)
public class EmailTest {

	@DisplayName("이메일 도메인 검증")
	@Test
	void 이메일_도메인_검증() {
		assertThatThrownBy(
			() -> new Email("test@error.com")
		).isInstanceOf(IllegalArgumentException.class);

		assertThat(new Email("test@email.com")).isNotNull();
	}
}
