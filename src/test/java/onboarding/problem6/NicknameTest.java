package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NicknameTest {

	@ParameterizedTest(name = "{0}, {1}에는 중복이 있다 == {2}")
	@CsvSource(value = {"제이엠,제이슨,true", "가나다라,다,false", "가다가다,가가,false", "가가이슨,나나이슨,true"})
	void check_if_nickname_has_overlap(String name, String otherName, boolean expected) {
		Nickname nickname = new Nickname(name);
		Nickname otherNickname = new Nickname(otherName);

		assertThat(nickname.hasOverlapOf(otherNickname)).isEqualTo(expected);
	}
}
