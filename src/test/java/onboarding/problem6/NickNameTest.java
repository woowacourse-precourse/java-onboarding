package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NickNameTest {

	@Test
	void nickname_range() {
		assertThatThrownBy(() -> new Nickname("스물".repeat(10))).hasMessage("닉네임은 20자를 넘을수 없습니다.");

		assertThatCode(() -> new Nickname("열" + "아홉".repeat(9))).doesNotThrowAnyException();
	}

	@Test
	void korean_nickname() {
		assertThatThrownBy(() -> new Nickname("s스몰")).hasMessage("넥네임은 한글만 가능합니다.");

		assertThatCode(() -> new Nickname("열" + "아홉".repeat(9))).doesNotThrowAnyException();
	}
}
