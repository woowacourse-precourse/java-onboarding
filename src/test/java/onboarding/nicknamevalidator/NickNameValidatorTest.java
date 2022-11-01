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
		List.of("nowm@email.com", "이제엠"),
		List.of("test@email.com", "제이엠이엠제이")
	);

	static NickNameValidator validator
		= new NickNameValidator(forms);
	//
	// @DisplayName("닉네임 문자 순열 생성 테스트")
	// @Test
	// void 닉네임_문자_순열_생성() {
	// 	assertThat(NickNameValidator.getPermutationOf("제이엠"))
	// 		.containsAll(List.of("제이", "이엠"));
	//
	// 	assertThat(NickNameValidator.getPermutationOf("워니"))
	// 		.containsAll(List.of("워니"));
	//
	// 	assertThat(NickNameValidator.getPermutationOf("엠제이"))
	// 		.containsAll(List.of("엠제", "제이"));
	//
	// 	assertThat(NickNameValidator.getPermutationOf("제이엠"))
	// 		.containsAll(List.of("제이", "이엠"));
	//
	// 	assertThat(NickNameValidator.getPermutationOf("제이엠군고"))
	// 		.containsAll(List.of("제이", "이엠", "엠군", "군고", "이엠", "엠군", "군고"));
	// }

	@DisplayName("포함된 단어 횟수 반환 테스트")
	@Test
	void 단어_포함_횟수() {
		assertThat(validator.getOccurrenceOf("제이"))
			.isEqualTo(4);
		assertThat(validator.getOccurrenceOf("이엠"))
			.isEqualTo(2);
		assertThat(validator.getOccurrenceOf("이엠제"))
			.isEqualTo(0);
	}

	@DisplayName("단어가 포함된 닉네임 이메일 반환 테스트")
	@Test
	void 단어_포함_닉네임_이메일() {
		List<String> emails = validator.getEmailsMatches("제이");
		assertThat(emails)
			.containsAll(List.of(
				"jm@email.com", "test@email.com",
				"jason@email.com", "mj@email.com"));
	}

	@DisplayName("중복된 닉네임 이메일 반환 테스트")
	@Test
	void 중복_닉네임_이메일_반환() {
		List<String> emails = validator.getInvalidEmails();
		assertThat(emails)
			.isEqualTo(List.of("jason@email.com",
				"jm@email.com", "mj@email.com", "test@email.com"));
	}
}
