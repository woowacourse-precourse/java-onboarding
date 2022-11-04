package onboarding.friendrecommendationsystem.review;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

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

	@DisplayName("아이디 형식 검증")
	@Test
	void 아이디_형식_검증() {
		for (String id : List.of("MRKO", "Mrko")) {
			assertThatThrownBy(
				() -> new User(id)
			).isInstanceOf(IllegalArgumentException.class);
		}
		assertThat(new User("mrko")).isNotNull();
	}
}
