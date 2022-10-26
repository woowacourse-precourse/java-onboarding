package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {
	@DisplayName("숫자를 그대로 문자열로 변환")
	@ParameterizedTest(name = "Parse number {0} to string, is ''{1}''")
	@CsvSource(value = {"123:123", "13:13", "43:43", "264:264", "0:0", "-13:-13"}, delimiter = ':')
	void parseIntToStringTest(int page, String expected) {
		// given : 테스트를 진행할 Problem1의 객체 인스턴스
		final Problem1 problem1 = new Problem1();

		// when : page number 를 parsing 할 때를 확인하기 위해
		String parsedResult = problem1.parsePageNumber(page);

		// then : 숫자는 그대로 문자열로 변경되어야 함.
		assertThat(parsedResult).isEqualTo(expected);
	}

	@DisplayName("문자열의 각 자리의 합 구하는 기능")
	@ParameterizedTest(name = "The sum of string digits ''{0}'', is {1}")
	@CsvSource(value = {"123:6", "13:4", "43:7", "264:12", "348274592374592457:90", "0:0", "10:1"}, delimiter = ':')
	void calculateSumOfStringDigits(String stringNumber, int expected) {
		// given : 테스트를 진행할 Problem1의 객체 인스턴스
		final Problem1 problem1 = new Problem1();

		// when : 문자열의 각 자리 수 합을 구할 때
		int sum = problem1.calculateSumOfStringDigits(stringNumber);

		// 각 자리수 합이 정상적으로 나오는지 확인
		assertThat(sum).isEqualTo(expected);
	}

	@DisplayName("문자열의 각 자리 곱셈을 구하는 기능")
	@ParameterizedTest(name = "The multiplication of string digits ''{0}'', is {1}")
	@CsvSource(value = {"123:6", "13:3", "43:12", "264:48", "13140:0",
			"43251:120", "348274592374592457:995147776", "999999999999999999990:0"}, delimiter = ':')
	void calculateMultiplicationOfStringDigits(String stringNumber, int expected) {
		// given : 테스트를 진행할 Problem1의 객체 인스턴스
		final Problem1 problem1 = new Problem1();

		// when : 문자열의 각 자리 수 곱을 구할 때
		int multiplication = problem1.calculateMultiplicationOfStringDigits(stringNumber);

		// 각 자리수 곱이 정상적으로 나오는지 확인
		assertThat(multiplication).isEqualTo(expected);
	}
}