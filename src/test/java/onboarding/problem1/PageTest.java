package onboarding.problem1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PageTest {

	@ParameterizedTest(name = "각 자리 숫자를 모두 더할 수 있다")
	@CsvSource(value = {"12345=15", "0=0", "110=2"}, delimiter = '=')
	void add_all_digits(int pageNumber, int expected) {
		Page page = new Page(pageNumber);

		assertThat(page.addAllDigits()).isEqualTo(expected);
	}
}
