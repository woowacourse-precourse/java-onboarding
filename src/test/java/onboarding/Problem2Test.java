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

	@ParameterizedTest(name = "''{0}'' has valid length? ==> {1}")
	@CsvSource(value = {"fndf:true", "a:true", "'':false"}, delimiter = ':')
	void cryptogramLengthValidTest(String cryptogram, boolean expected) {
		// when : 현재 들어온 암호의 길이가 1~1000 범위를 만족하는지 확인
		boolean validationResult = Problem2.isValidLength(cryptogram);

		// then : 유효한 길이라면 true, else false
		assertThat(validationResult).isEqualTo(expected);
	}

	@ParameterizedTest(name = "''{0}'' has valid format? ==> {1}")
	@CsvSource(value = {"fna:true", "ffNf:false", "f:true", "f4na:false", "fnn_n:false", "r=r:false",
			"fja`geg:false", "'':false", "af ag:false"}, delimiter = ':')
	void validateCryptogramAllLowerCaseCharacterTest(String cryptogram, boolean expected) {
		// when : 들어온 암호가 모두 소문자 알파벳인지 확인할 때
		boolean validationResult = Problem2.isLowerCaseCharacters(cryptogram);

		// then : 모두 소문자 알파벳이라면 true, else false
		assertThat(validationResult).isEqualTo(expected);
	}

	@ParameterizedTest(name = "validate test ''{0}'' ==> {1}")
	@CsvSource(value = {"fna:true", "ffNf:false", "f:true", "f4na:false", "fnn_n:false", "r=r:false",
			"fja`geg:false", "'':false", "af ag:false", "knldaf:true"}, delimiter = ':')
	void validateCryptogramInputFormatTest(String cryptogram, boolean expected) {
		// when : 들어온 암호가 유효한지 확인
		boolean validationResult = Problem2.validateCryptogramFormat(cryptogram);

		// then : 유효하다면 true, else false
		assertThat(validationResult).isEqualTo(expected);
	}
}