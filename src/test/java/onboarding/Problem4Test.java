package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Problem4Test {
	@ParameterizedTest(name = "문자 ''{0}''를 반대로 변환 ==> ''{1}''")
	@CsvSource(value = {"a:z", "A:Z", "g:t", "G:T", "T:G", "Z:A", "f:u", "U:F", "H:S", "n:m", "M:N",
			"0:0", "~:~", "!:!", "' ':' '"}, delimiter = ':')
	void convertOneCharToOppositeTest(char letter, char expected) {
		// when : letter 문자를 반대로 바꿀 때
		char opposedChar = Problem4.convertCharacterToOpposite(letter);

		// then : 잘 바뀌는지 확인
		assertThat(opposedChar).isEqualTo(expected);
	}

	@ParameterizedTest(name = "Text ''''{0}'''' ==opposite all==> ''''{1}''''")
	@CsvSource(value = {"A:Z", "HellO:SvooL", "WorlD:DlioW", "0A9FnUqQ:0Z9UmFjJ", "`Hello World~!:`Svool Dliow~!",
			"  Wooteco is my LIFE    ~ !  :  Dllgvxl rh nb ORUV    ~ !  "},
			delimiter = ':', ignoreLeadingAndTrailingWhitespace = false)
	void convertTextToOppositeTest(String text, String expected) {
		// when : text 의 문자들을 모두 반대로 바꿀 때
		String convertedResult = Problem4.convertTextToOpposite(text);
		System.out.println("input text = START$" + text + "$END");
		System.out.println("convertedResult = START$" + convertedResult + "$$END");

		// then : 잘 바뀌었는지 확인
		assertThat(convertedResult).isEqualTo(expected);
	}

	@DisplayName("StringBuilder 의 좌우에 공백을 삽입했을 때 만들어지는 문자열 확인")
	@Test
	void stringBuilderWhitespaceTest() {
		// given : StringBuilder 에 좌우공백을 append 로 추가한 객체
		StringBuilder sb = new StringBuilder();
		sb.append(' ');
		sb.append(' ');
		sb.append(' ');
		sb.append("Hello");
		sb.append(' ');
		sb.append(' ');

		// when : StringBuilder 객체를 문자열로 바꿨을 때
		String result = sb.toString();

		// then : 주어진 문자열과 같은지 확인
		final String expected = "   Hello  ";

		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("convertTextToOpposite method 로 문자열을 변환할 때 좌우공백이 사라지는지 확인")
	@Test
	void convertTextToOppositeWhitespaceIgnoreTest() {
		// given : 좌우에 공백이 있는 문자열
		final String stringWithWhitespaceOnSides = "    Hello World  ";

		// when : 좌우 공백이 존재하는 문자열을 모두 반대로 바꿨을 때
		String convertedResult = Problem4.convertTextToOpposite(stringWithWhitespaceOnSides);

		// then : 변환된 결과(result)의 좌우 공백이 사라졌는지 확인
		final String expected = "    Svool Dliow  ";
		System.out.println("convertedResult = START$" + convertedResult + "$END");
		System.out.println("expected = $START" + expected + "$END");
		assertThat(convertedResult).isEqualTo(expected);
	}

	@ParameterizedTest(name = "MAIN TEST ''''{0}'''' ==> ''''{1}''''")
	@CsvSource(value = {"    :    ", " ABc D : ZYx W ", "'':''", "Hello World:Svool Dliow",
			"WooTeCo is AWESOME!  :DllGvXl rh ZDVHLNV!  "},
			delimiter = ':', ignoreLeadingAndTrailingWhitespace = false)
	void solutionTest(String word, String expected) {
		String result = Problem4.solution(word);

		assertThat(result).isEqualTo(expected);
	}
}