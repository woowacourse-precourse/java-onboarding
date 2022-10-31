package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserIDTest {

	@Test
	void userID_range() {
		assertThatThrownBy(() -> new UserID("a".repeat(31))).hasMessage("사용자 아이디는 길이가 1 이상 30 이하인 문자열이다.")
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new UserID("a".repeat(0))).hasMessage("사용자 아이디는 길이가 1 이상 30 이하인 문자열이다.")
			.isInstanceOf(IllegalArgumentException.class);

		assertThatCode(() -> new UserID("a".repeat(30))).doesNotThrowAnyException();
		assertThatCode(() -> new UserID("a".repeat(1))).doesNotThrowAnyException();
	}

	@Test
	void userID_type() {
		assertThatThrownBy(() -> new UserID("Abc")).hasMessage("사용자 아이디는 알파벳 소문자로만 이루어져야 있다.")
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new UserID("1s*")).hasMessage("사용자 아이디는 알파벳 소문자로만 이루어져야 있다.")
			.isInstanceOf(IllegalArgumentException.class);

		assertThatCode(() -> new UserID("avc")).doesNotThrowAnyException();
	}
}
