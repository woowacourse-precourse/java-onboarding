package onboarding;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Problem4Test {
	@ParameterizedTest(name = "문자 ''{0}''를 반대로 변환 ==> ''{1}''")
	@CsvSource(value = {"a:z", "A:Z", "g:t", "G:T", "T:G", "Z:A", "f:u", "U:F", "H:S", "n:m", "M:N",
			"0:0", "~:~", "!:!"}, delimiter = ':')
	void convertOneCharToOppositeTest(char letter, char expected) {
		char opposedChar = Problem4.convertCharacterToOpposite(letter);

		assertThat(opposedChar).isEqualTo(expected);
	}

}