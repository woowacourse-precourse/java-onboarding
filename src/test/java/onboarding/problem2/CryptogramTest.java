package onboarding.problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CryptogramTest {

	@Test
	void clear_consecutive_duplicate_character() {
		String testString1 = "aaabcdeeefhfee";
		assertEquals("bcdfhf", Cryptogram.getRightAnswer(testString1));

		String testString2 = "bbccdd";
		assertEquals("", Cryptogram.getRightAnswer(testString2));
	}

}
