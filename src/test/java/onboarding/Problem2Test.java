package onboarding;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Problem2Test {

	@Test
	void 범위체크() {
		assertThrows(IllegalArgumentException.class, () ->
			Problem2.solution("")
		);

	}
}