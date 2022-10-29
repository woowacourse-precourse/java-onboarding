package onboarding.nicknamevalidator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NickNameValidatorTest {

	@DisplayName("닉네임 문자 순열 생성 테스트")
	@Test
	void 닉네임_문자_순열_생성() {
		assertThat(NickNameValidator.getPermutationOf("제이엠"))
			.isEqualTo(List.of("제이", "제이엠", "이엠"));

		assertThat(NickNameValidator.getPermutationOf("워니"))
			.isEqualTo(List.of("워니"));

		assertThat(NickNameValidator.getPermutationOf("엠제이"))
			.isEqualTo(List.of("엠제", "엠제이", "제이"));
		
		assertThat(NickNameValidator.getPermutationOf("제이엠"))
			.isEqualTo(List.of("제이", "제이엠", "이엠"));
	}
}
