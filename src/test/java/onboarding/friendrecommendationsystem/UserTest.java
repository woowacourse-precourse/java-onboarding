package onboarding.friendrecommendationsystem;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(
	DisplayNameGenerator.ReplaceUnderscores.class
)
public class UserTest {

	@DisplayName("닉네임 길이 검증")
	@Test
	void 닉네임_길이_검증() {
		Assertions.assertThatThrownBy(
			() -> new Nickname("")
		).isInstanceOf(IllegalArgumentException.class);
	}

}
