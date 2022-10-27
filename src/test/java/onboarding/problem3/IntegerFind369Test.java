package onboarding.problem3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegerFind369Test {

	@Test
	void count_369_quantity() {
		int testNum1 = 369;
		Assertions.assertEquals(IntegerFind369.getCount(testNum1), 3);

		int testNum2 = 8944756;
		Assertions.assertEquals(IntegerFind369.getCount(testNum2), 2);
	}
}
