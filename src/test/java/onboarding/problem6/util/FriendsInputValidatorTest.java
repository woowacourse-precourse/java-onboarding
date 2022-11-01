package onboarding.problem6.util;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FriendsInputValidatorTest {
	@Nested
	class Problem6Test {
		@Test
		void 입력된_List의_size_체크() {
			// give
			List<List<String>> forms = List.of(
					List.of("jm@email.com", "제이엠"),
					List.of("jason@email.com", "제이슨"),
					List.of("woniee@email.com", "워니"),
					List.of("mj@email.com", "엠제이"),
					List.of("nowm@email.com", "이제엠")
			);
			// when
			boolean resultPassed = true;
			// then
			assertThat(FriendsInputValidator.sizeValidator(forms)).isEqualTo(resultPassed);
		}

		@Test
		void 입력된_List의_email_형식_체크() {
			// give
			List<List<String>> forms = List.of(
					List.of("jm@email.com", "제이엠"),
					List.of("jason@email.com", "제이슨"),
					List.of("woniee@email.com", "워니"),
					List.of("mj@email.com", "엠제이"),
					List.of("nowm@email.com", "이제엠")
			);
			// when
			boolean resultPassed = true;
			// then
			assertThat(FriendsInputValidator.emailValidator(forms)).isEqualTo(resultPassed);
		}

		@Test
		void 입력된_List의_닉네임_한글_여부() {
			// give
			List<List<String>> forms = List.of(
					List.of("jm@email.com", "제이엠"),
					List.of("jason@email.com", "제이슨"),
					List.of("woniee@email.com", "워니"),
					List.of("mj@email.com", "엠제이"),
					List.of("nowm@email.com", "이제엠")
			);
			// when
			boolean resultPassed = true;
			// then
			assertThat(FriendsInputValidator.nicknameValidator(forms)).isEqualTo(resultPassed);
		}
	}
}
