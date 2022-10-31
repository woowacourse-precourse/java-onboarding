package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EmailTest {

	@Test
	void email_range() {
		assertThatThrownBy(() -> new Email("20jmsonkoo@email.com")).hasMessage("이메일은 전체 길이는 11자 이상 20자 미만이다");

		assertThatThrownBy(() -> new Email("@email.com")).hasMessage("이메일은 전체 길이는 11자 이상 20자 미만이다");

		assertThatCode(() -> new Email("koo@email.com")).doesNotThrowAnyException();
	}

	@Test
	void email_type() {
		assertThatThrownBy(() -> new Email("jmson@gmail.com")).hasMessage("이메일 형식이 부합하지 않습니다 혹은 email.com 도메인을 사용하새요.");
		assertThatThrownBy(() -> new Email("jm&son@email.com")).hasMessage(
			"이메일 형식이 부합하지 않습니다 혹은 email.com 도메인을 사용하새요.");

		assertThatCode(() -> new Email("koo@email.com")).doesNotThrowAnyException();
	}
}
