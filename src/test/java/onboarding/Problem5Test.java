package onboarding;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Problem5Test {

	@Test
	void 숫자범위확인() {
		assertThrows(IllegalArgumentException.class, () ->
			Problem5.solution(1000001));

		assertThrows(IllegalArgumentException.class, () ->
			Problem5.solution(0));
	}
}