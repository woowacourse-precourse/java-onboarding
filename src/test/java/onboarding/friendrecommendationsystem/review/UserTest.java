package onboarding.friendrecommendationsystem.review;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(
	DisplayNameGenerator.ReplaceUnderscores.class
)
public class UserTest {

	@DisplayName("아이디 길이 검증")
	@Test
	void 아이디_길이_검증() {
		assertThatThrownBy(
			() -> new User("")
		).isInstanceOf(IllegalArgumentException.class);

		assertThat(new User("mrko")).isNotNull();
	}
}
