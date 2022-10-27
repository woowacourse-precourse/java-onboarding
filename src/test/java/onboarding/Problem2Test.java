package onboarding;

import static onboarding.Problem2.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class Problem2Test {

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
	void getTwoCharsDeletedInGivenIdxTest1() {
		String string = "abcdefg";

		assertThat(getTwoCharsDeletedInGivenIdx(string, 0)).isEqualTo("cdefg");
		assertThat(getTwoCharsDeletedInGivenIdx(string, 1)).isEqualTo("adefg");
		assertThat(getTwoCharsDeletedInGivenIdx(string, 2)).isEqualTo("abefg");
		assertThat(getTwoCharsDeletedInGivenIdx(string, 3)).isEqualTo("abcfg");
		assertThat(getTwoCharsDeletedInGivenIdx(string, 4)).isEqualTo("abcdg");
		assertThat(getTwoCharsDeletedInGivenIdx(string, 5)).isEqualTo("abcde");
	}
}
