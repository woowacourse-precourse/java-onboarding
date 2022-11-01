package onboarding.problem6;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class EmailTest {
	@Test
	public void 이메일_유효성_테스트() {
	    //given
		String correctEmailInput = "jason@email.com";
		String wrongEmailInput1 = "jason@naver.com";
		String wrongEmailInput2 = "jasonjason2@email.com";
		String wrongEmailInput3 = "@email.com";

		Email email = new Email(correctEmailInput);
		assertThat(correctEmailInput).isEqualTo(email.toString());

		assertThatThrownBy(() -> new Email(wrongEmailInput1))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new Email(wrongEmailInput2))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new Email(wrongEmailInput3))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
