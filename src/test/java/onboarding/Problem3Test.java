package onboarding;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Problem3Test {
	@ParameterizedTest
	@CsvSource(value = {"1:0", "123:1", "23:1", "33:2", "12413:1", "369:3", "612:1", "9546:2"}, delimiter = ':')
	void count369Test(String number, int expected) {
		int countResult = Problem3.count369(number);

		assertThat(countResult).isEqualTo(expected);
	}
}