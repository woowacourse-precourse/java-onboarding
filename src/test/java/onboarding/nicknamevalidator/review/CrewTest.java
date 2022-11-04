package onboarding.nicknamevalidator.review;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(
	DisplayNameGenerator.ReplaceUnderscores.class
)
public class CrewTest {

	@DisplayName("크루 매개변수 검증")
	@Test
	void 크루_매개변수_검증() {
		assertThatThrownBy(
			() -> new Crew("제이엠", "jm@error.com")
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("크루 정보 반환 테스트")
	@Test
	void 크루_정보_반환() {
		Crew crew = new Crew("제이엠", "jm@email.com");

		assertThat(
			crew.getNickname()
		).isEqualTo("제이엠");

		assertThat(
			crew.getEmail()
		).isEqualTo("jm@email.com");

		assertThat(
			crew.getPartsOfName()
		).containsAll(
			List.of("제이", "이엠")
		);
	}

}
