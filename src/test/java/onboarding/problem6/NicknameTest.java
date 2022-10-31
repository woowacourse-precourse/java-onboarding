package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NicknameTest {

	private static final String NICKNAME_LENGTH_20 = "a".repeat(20);
	public static final String NICKNAME_LENGTH_0 = "";

	@ParameterizedTest(name = "{0}, {1}에는 중복이 있다 == {2}")
	@CsvSource(value = {"제이엠,제이슨,true", "가나다라,다,false", "가다가다,가가,false", "가가이슨,나나이슨,true"})
	void check_if_nickname_has_overlap(String name, String otherName, boolean expected) {
		Nickname nickname = new Nickname(name);
		Nickname otherNickname = new Nickname(otherName);

		assertThat(nickname.hasOverlapWith(otherNickname)).isEqualTo(expected);
	}

	@Test
	@DisplayName("닉네임은 1자이상 20자 미만이다")
	void nickname_has_length_but_less_than_20() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Nickname(NICKNAME_LENGTH_0));
		assertThatIllegalArgumentException().isThrownBy(() -> new Nickname(NICKNAME_LENGTH_20));
	}

	@Test
	@DisplayName("닉네임은 null이 아니다")
	void nickname_is_not_null() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Nickname(null));
	}
}
