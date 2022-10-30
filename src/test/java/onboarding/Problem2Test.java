package onboarding;

import static onboarding.Problem2.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class Problem2Test {

	@Nested
	class IntegrationTest {

		@Test
		@DisplayName("browoanoommnaon을 brown으로 줄여야 한다")
		void integrationTest1() {
			assertThat(solution("browoanoommnaon")).isEqualTo("brown");
		}

		@Test
		@DisplayName("zyelleyz을 빈 문자열로 줄여야 한다")
		void integrationTest2() {
			assertThat(solution("zyelleyz")).isEqualTo("");
		}

		@Test
		@DisplayName("aabbccd를 d로 줄여야 한다")
		void integrationTest3() {
			assertThat(solution("aabbccd")).isEqualTo("d");
		}

		@Test
		@DisplayName("bgfaafgecddce를 b로 줄여야 한다")
		void integrationTest4() {
			assertThat(solution("bgfaafgecddce")).isEqualTo("b");
		}
	}

	@Test
	@DisplayName("주어진 인덱스와 다음 인덱스의 문자가 중복일 때만 참을 반환해야 한다")
	void isCharsDuplicatedInGivenIdxTest() {
		String string = "12344";
		assertFalse(isCharsDuplicatedInGivenIdx(string, 0));
		assertFalse(isCharsDuplicatedInGivenIdx(string, 1));
		assertFalse(isCharsDuplicatedInGivenIdx(string, 2));
		assertTrue(isCharsDuplicatedInGivenIdx(string, 3));
	}

	@Test
	@DisplayName("문자열에서 주어진 인덱스와 그 다음의 두 문자를 삭제해야 한다")
	void deleteTwoCharsFromIdxTest() {
		String string = "abcdefg";
		assertThat(deleteTwoCharsFromIdx(string, 0)).isEqualTo("cdefg");
		assertThat(deleteTwoCharsFromIdx(string, 1)).isEqualTo("adefg");
		assertThat(deleteTwoCharsFromIdx(string, 2)).isEqualTo("abefg");
		assertThat(deleteTwoCharsFromIdx(string, 3)).isEqualTo("abcfg");
		assertThat(deleteTwoCharsFromIdx(string, 4)).isEqualTo("abcdg");
		assertThat(deleteTwoCharsFromIdx(string, 5)).isEqualTo("abcde");
	}
}
