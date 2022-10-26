package onboarding;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Problem4Test {
	@Test
	void 범위확인() {
		assertThrows(IllegalArgumentException.class, () ->
			Problem4.checkValidRange(1001)
		);

		assertThrows(IllegalArgumentException.class, () ->
			Problem4.checkValidRange(0)
		);
	}
}