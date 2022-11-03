package onboarding.friendrecommendationsystem;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

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

	@DisplayName("닉네임에서 일련 길이의 연속적인 문자들을 구할 수 있다.")
	@Test
	void 닉네임_일련길이_문자_목록() {
		Nickname nickname = new Nickname("제이엠");
		assertThat(nickname.getPartsOfName(2))
			.containsAll(List.of("제이", "이엠"));

		nickname = new Nickname("이제엠");
		assertThat(nickname.getPartsOfName(2))
			.containsAll(List.of("이제", "제엠"));
	}
}
