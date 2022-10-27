package onboarding.problem3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckNumberTest {

	@Test
	void check_number_range() {
		int testNumber1 = 0;
		assertFalse(CheckNumber.of(testNumber1));

		int testNumber2 = 15000;
		assertFalse(CheckNumber.of(testNumber2));

		int testNumber3 = 800;
		assertTrue(CheckNumber.of(testNumber3));

	}
}
