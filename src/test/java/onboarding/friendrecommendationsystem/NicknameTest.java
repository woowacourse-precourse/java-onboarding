package onboarding.friendrecommendationsystem;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(
	DisplayNameGenerator.ReplaceUnderscores.class
)
public class NicknameTest {

	@DisplayName("닉네임 길이 검증")
	@Test
	void 닉네임_길이_검증() {
		assertThatThrownBy(
			() -> new Nickname("")
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("닉네임 한글 검증")
	@Test
	void 닉네임_한글_검증() {
		assertThatThrownBy(
			() -> new Nickname("English")
		).isInstanceOf(IllegalArgumentException.class);

		assertThat(new Nickname("한글")).isNotNull();
	}
}
