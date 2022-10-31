package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RequestTest {

	@Test
	@DisplayName("신청은 이메일과 닉네임을 포함한다")
	void request_contains_email_and_nickname() {
		List<String> invalidForm = List.of("nowm@email.com");

		assertThatIllegalArgumentException().isThrownBy(() -> new Request(invalidForm));
	}

}