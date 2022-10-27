package onboarding;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {
	@ParameterizedTest(name = "''{0}'' -- erase once --> ''{1}''")
	@CsvSource(value = {"a:a", "aabb:''", "abc:abc", "aabc:bc", "abaabac:abbac", "aabbbbdccdq:ddq",
			"mmbnnnnnnnnnnabr:babr", "abccabc:ababc", "ab:ab", "bbbbbb:''", "abbabba:aaa"}, delimiter = ':')
	void stringEraseTest(String input, String expected) {
		// when : input 에서 같은 문자가 연속한 경우 빈 문자로 대체
		String erasedString = Problem2.eraseSuccessiveCharacters(input);

		// then : 연속하는 같은 문자들이 제거됐는지 확인
		assertThat(erasedString).isEqualTo(expected);
	}

	@ParameterizedTest(name = "''{0}'' -- erase until unchanged --> ''{1}''")
	@CsvSource(value = {"a:a", "aabb:''", "abc:abc", "aabc:bc", "abaabac:c", "aabbbbdccdq:q",
			"mmbnnbr:r", "abccabc:ababc", "ab:ab", "bbbbbb:''", "abbabba:''", "nbdbddn:nbdbn"}, delimiter = ':')
	void stringEraseUtilUnchangedTest(String input, String expected) {
		// when : input 에서 같은 문자가 더이상 연속하지 않을 때까지 빈 문자로 바꾸기
		String output = Problem2.eraseSuccessiveCharactersUntilUnchanged(input);

		// then : 연속하지 않을 때까지 빈 문자로 바뀌었는지 확인
		assertThat(output).isEqualTo(expected);
	}
}