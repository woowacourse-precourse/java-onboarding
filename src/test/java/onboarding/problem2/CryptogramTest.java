package onboarding.problem2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CryptogramTest {

	@ParameterizedTest(name = "연속하는 중복 문자를 제거할 수 있다")
	@CsvSource(value = {"zyelleyz=''", "llllll=''", "uuc=c", "c=c"}, delimiter = '=')
	void remove_series_of_overlap_character(String encrypted, String expected) {
		Cryptogram cryptogram = new Cryptogram(encrypted);

		Assertions.assertThat(cryptogram.decrypt()).isEqualTo(expected);
	}
}
