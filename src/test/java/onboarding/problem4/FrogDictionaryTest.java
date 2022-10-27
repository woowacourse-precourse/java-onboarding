package onboarding.problem4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FrogDictionaryTest {

	@ParameterizedTest(name = "글자를 검색한다")
	@CsvSource(value = {"A=Z", "z=a", "b=y"}, delimiter = '=')
	void find_character(char character, char expected) {
		FrogDictionary frogDictionary = new FrogDictionary();
		Assertions.assertThat(frogDictionary.find(character)).hasValue(expected);
	}
}
