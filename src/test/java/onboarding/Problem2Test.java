package onboarding;

import static onboarding.Problem2.*;
import static org.junit.jupiter.api.Assertions.*;

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
}
