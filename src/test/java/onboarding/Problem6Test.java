package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class Problem6Test {

	@Test
	void 잘못된_닉네임() {
		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightNickname("english"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightNickname("한글이지만범위가매우깁니다정말길게만들어야해요"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightNickname("dugk하하하"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightNickname("닉네임에 공백이 있어요"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightNickname("ㄱㄴㄷㄹ"));
	}

	@Test
	void 올바른_닉네임() {
		boolean result = true;
		assertThat(Problem6.InputValidator.isRightNickname("제이슨")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightNickname("안녕안녕")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightNickname("딸기에요")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightNickname("제이슨")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightNickname("워니")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightNickname("엠제이")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightNickname("이제엠")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightNickname("테스트")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightNickname("테스트입니당")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightNickname("테스트가길어져도될까요")).isEqualTo(result);

	}

	@Test
	void 잘못된_이메일() {

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail("en@@g@dd@email.com"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail("engh@dd@email.com"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail("@email.com"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail("english@@email.com"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail("sadsasd@emailcom"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail("한글@email.com"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail(""));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail("sadsfasdadasdsasd@emailcom"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem6.InputValidator.isRightEmail(" @email.com"));
	}

	@Test
	void 올바른_이메일() {
		boolean result = true;
		assertThat(Problem6.InputValidator.isRightEmail("sdf@email.com")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightEmail("sdfb3dd@email.com")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightEmail("34sdfds@email.com")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightEmail("sfbb@email.com")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightEmail("asdasdw2@email.com")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightEmail("sadd@email.com")).isEqualTo(result);
		assertThat(Problem6.InputValidator.isRightEmail("hsdfsdf@email.com")).isEqualTo(result);
	}

	@Test
	void 중복_단어_집합_구하기() {
		List<String> nicknames = List.of("제이슨", "제이쿠", "소이쿠");
		Set<String> result = new HashSet<>(List.of("제이", "이쿠"));
		assertThat(Problem6.getOverlapWords(nicknames)).isEqualTo(result);

		nicknames = List.of("바나나", "바나나", "딸기", "복숭아", "숭아");
		result = new HashSet<>(List.of("바나", "나나", "숭아"));
		assertThat(Problem6.getOverlapWords(nicknames)).isEqualTo(result);

		nicknames = List.of("안녕안녕");
		result = new HashSet<>(List.of());
		assertThat(Problem6.getOverlapWords(nicknames)).isEqualTo(result);

		nicknames = List.of("안녕안녕", "안녕");
		result = new HashSet<>(List.of("안녕"));
		assertThat(Problem6.getOverlapWords(nicknames)).isEqualTo(result);
	}

	@Test
	void 같은_단어_집합_구하기() {
		List<String> nicknames = List.of("제이슨", "제이쿠", "소이쿠");
		Set<String> result = new HashSet<>(List.of("제이", "이쿠"));
		assertThat(Problem6.getOverlapWords(nicknames)).isEqualTo(result);

		nicknames = List.of("바나나", "바나나", "딸기", "복숭아", "숭아");
		result = new HashSet<>(List.of("바나", "나나", "숭아"));
		assertThat(Problem6.getOverlapWords(nicknames)).isEqualTo(result);

		nicknames = List.of("안녕안녕");
		result = new HashSet<>(List.of());
		assertThat(Problem6.getOverlapWords(nicknames)).isEqualTo(result);

		nicknames = List.of("안녕안녕", "안녕");
		result = new HashSet<>(List.of("안녕"));
		assertThat(Problem6.getOverlapWords(nicknames)).isEqualTo(result);
	}
}
