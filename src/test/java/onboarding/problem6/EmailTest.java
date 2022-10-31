package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmailTest {

	@Test
	@DisplayName("이메일은 이메일 형식을 가진다")
	void email_has_format_of_email() {
		assertThatNoException().isThrownBy(() -> new Email("test@email.com"));
		assertThatIllegalArgumentException().isThrownBy(() -> new Email("test@."));
	}
}
