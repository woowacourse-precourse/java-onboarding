package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Problem7Test {

	@Test
	void 올바른_user_입력() {
		boolean result = true;
		assertThat(Problem7.InputValidator.isRightUserInput("hello")).isEqualTo(result);
		assertThat(Problem7.InputValidator.isRightUserInput("me")).isEqualTo(result);
		assertThat(Problem7.InputValidator.isRightUserInput("this")).isEqualTo(result);
		assertThat(Problem7.InputValidator.isRightUserInput("lalala")).isEqualTo(result);
	}

	@Test
	void 잘못된_user_입력() {
		assertThrows(IllegalArgumentException.class, () ->
			Problem7.InputValidator.isRightUserInput("한글"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem7.InputValidator.isRightUserInput("ABCD"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem7.InputValidator.isRightUserInput("ABAdd"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem7.InputValidator.isRightUserInput(""));

		assertThrows(IllegalArgumentException.class, () ->
			Problem7.InputValidator.isRightUserInput("qwertyuiopasdfghjklzxcvbnmqwertyuiop"));
	}
}