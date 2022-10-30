package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Problem6Test {

	@Test
	void 잘못된_이메일() {

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail("en@@g@dd@email.com"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail("engh@dd@email.com"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail("@email.com"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail("english@@email.com"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail("sadsasd@emailcom"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail("한글@email.com"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail(""));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail("sadsfasdadasdsasd@emailcom"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail(" @email.com"));
	}

	@Test
	void 올바른_이메일() {
		boolean result = true;
		assertThat(Problem6.InputValidator.isRightEmail("sdf@email.com")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightEmail("sdfb3dd@email.com")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightEmail("34sdfds@email.com")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightEmail("sfbb@email.com")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightEmail("asdasdw2@email.com")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightEmail("sadd@email.com")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightEmail("hsdfsdf@email.com")).isEqualTo(result);
	}
}
