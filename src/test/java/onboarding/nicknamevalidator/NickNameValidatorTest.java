package onboarding.nicknamevalidator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NickNameValidatorTest {

	static List<List<String>> forms = List.of(
		List.of("jm@email.com", "제이엠"),
		List.of("jason@email.com", "제이슨"),
		List.of("woniee@email.com", "워니"),
		List.of("mj@email.com", "엠제이"),
		List.of("nowm@email.com", "이제엠")
	);

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

	@DisplayName("포함된 단어 횟수 반환 테스트")
	@Test
	void 단어_포함_횟수() {
		NickNameValidator validator = new NickNameValidator(forms);
		assertThat(validator.getOccurrenceOf("제이"))
			.isEqualTo(3);
		assertThat(validator.getOccurrenceOf("이엠"))
			.isEqualTo(1);
		assertThat(validator.getOccurrenceOf("이엠제"))
			.isEqualTo(0);
	}
}
