package onboarding.problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckCrytogramTest {

	@Test
	void check_crytogram_null() {
		IllegalArgumentException illegalArgumentException =
			assertThrows(IllegalArgumentException.class, () -> CheckCrytogram.of(null));
		String message = illegalArgumentException.getMessage();
		assertEquals(message, "cryptogram가 null이면 안됩니다.");
	}

	@Test
	void crytogram_overflow_check() {
		StringBuilder testStringBuilder = new StringBuilder();
		int count = 0;
		while (count < 101) {
			testStringBuilder.append(Integer.MAX_VALUE);
			count++;
		}
		String testString = testStringBuilder.toString();
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
			() -> CheckCrytogram.of(testString));
		String message = illegalArgumentException.getMessage();

		assertEquals(message, "cyptogram은 1000 초과하면 안됩니다.");
	}

	@Test
	void check_is_all_lowercase() {
		String text1 = "Abbb";
		assertFalse(CheckCrytogram.of(text1));

		String text2 = "aaBb";
		assertFalse(CheckCrytogram.of(text2));

		String text3 = "cccdddddeesds";
		assertTrue(CheckCrytogram.of(text3));
	}

}
