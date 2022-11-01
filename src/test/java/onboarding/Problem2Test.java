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

		@Test
		@DisplayName("aaa를 빈 문자열로 줄여야 한다")
		void integrationTest5() {
			assertThat(solution("aaa")).isEqualTo("");
		}

		@Test
		@DisplayName("abbaa를 빈 문자열로 줄여야 한다")
		void integrationTest6() {
			assertThat(solution("abbaa")).isEqualTo("");
		}
	}

	@Test
	void getDuplicatedIdxFromSrcTest() {
		String string = "abcccddeffcc";
		assertThat(getDuplicatedIdxFromSrc(string, 0)).isEqualTo(0);
		assertThat(getDuplicatedIdxFromSrc(string, 1)).isEqualTo(1);
		assertThat(getDuplicatedIdxFromSrc(string, 2)).isEqualTo(4);
		assertThat(getDuplicatedIdxFromSrc(string, 3)).isEqualTo(4);
		assertThat(getDuplicatedIdxFromSrc(string, 4)).isEqualTo(4);
		assertThat(getDuplicatedIdxFromSrc(string, 5)).isEqualTo(6);
		assertThat(getDuplicatedIdxFromSrc(string, 6)).isEqualTo(6);
		assertThat(getDuplicatedIdxFromSrc(string, 7)).isEqualTo(7);
		assertThat(getDuplicatedIdxFromSrc(string, 8)).isEqualTo(9);
		assertThat(getDuplicatedIdxFromSrc(string, 9)).isEqualTo(9);
		assertThat(getDuplicatedIdxFromSrc(string, 10)).isEqualTo(11);
		assertThat(getDuplicatedIdxFromSrc(string, 11)).isEqualTo(11);
	}
}
