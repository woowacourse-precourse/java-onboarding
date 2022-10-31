package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {
	private static final int EXCEPTION_CASE = -1;
	private static final int DRAW = 0;
	private static final int POBI_WIN = 1;
	private static final int CRONG_WIN = 2;

	@DisplayName("숫자를 그대로 문자열로 변환")
	@ParameterizedTest(name = "Parse number {0} to string, is ''{1}''")
	@CsvSource(value = {"123:123", "13:13", "43:43", "264:264", "0:0", "-13:-13"}, delimiter = ':')
	void parseIntToStringTest(int page, String expected) {
		// given : 테스트를 진행할 Problem1의 객체 인스턴스
//		final Problem1 problem1 = new Problem1();

		// when : page number 를 parsing 할 때를 확인하기 위해
		String parsedResult = Problem1.parsePageNumber(page);

		// then : 숫자는 그대로 문자열로 변경되어야 함.
		assertThat(parsedResult).isEqualTo(expected);
	}

	@DisplayName("문자열의 각 자리의 합 구하는 기능")
	@ParameterizedTest(name = "The sum of string digits ''{0}'', is {1}")
	@CsvSource(value = {"232:7", "123:6", "13:4", "43:7", "264:12", "348274592374592457:90", "0:0", "10:1"}, delimiter = ':')
	void calculateSumOfStringDigits(String stringNumber, int expected) {
		// given : 테스트를 진행할 Problem1의 객체 인스턴스
//		final Problem1 problem1 = new Problem1();

		// when : 문자열의 각 자리 수 합을 구할 때
		int sum = Problem1.calculateSumOfStringDigits(stringNumber);

		// then : 각 자리수 합이 정상적으로 나오는지 확인
		assertThat(sum).isEqualTo(expected);
	}

	@DisplayName("문자열의 각 자리 곱셈을 구하는 기능")
	@ParameterizedTest(name = "The multiplication of string digits ''{0}'', is {1}")
	@CsvSource(value = {"232:12", "123:6", "13:3", "43:12", "264:48", "13140:0",
			"43251:120", "348274592374592457:995147776", "999999999999999999990:0"}, delimiter = ':')
	void calculateMultiplicationOfStringDigits(String stringNumber, int expected) {
		// given : 테스트를 진행할 Problem1의 객체 인스턴스
//		final Problem1 problem1 = new Problem1();

		// when : 문자열의 각 자리 수 곱을 구할 때
		int multiplication = Problem1.calculateMultiplicationOfStringDigits(stringNumber);

		// then : 각 자리수 곱이 정상적으로 나오는지 확인
		assertThat(multiplication).isEqualTo(expected);
	}

	@ParameterizedTest(name = "If the page is ''{0}'', then max(page sum, page multiplication) score is {1}")
	@CsvSource(value = {"231:6", "232:12", "234:24", "111:3", "10:1", "101:2"}, delimiter = ':')
	void getPageMaxScoreTest(int page, int expected) {
		// given : 테스트를 진행할 Problem1의 객체 인스턴스
//		final Problem1 problem1 = new Problem1();

		// when : 페이지의 각 자릿수 합, 곱 중에 최대값 구하기
		int maxScore = Problem1.getPageMaxScore(page);

		// then : 페이지의 각 자릿수 합, 곱의 최대값이 잘 나오는지 확인
		assertThat(maxScore).isEqualTo(expected);
	}

	@ParameterizedTest(name = "If player pages is ''{0}'', then the player max(left, right page) score is {1}")
	@MethodSource("generatePlayerPagesAndExpectedResult")
	void getPlayerMaxScore(List<Integer> playerPages, int expected) {
		// given : 테스트를 진행할 Problem1의 객체 인스턴스
//		final Problem1 problem1 = new Problem1();

		// when : 플레이어의 왼쪽, 오른쪽 페이지의 각 자릿수 합, 곱 중에 최대값 구하기
		int maxScore = Problem1.getPlayerMaxScore(playerPages);

		// then : 플레이어 점수의 최대값이 잘 나오는지 확인
		assertThat(maxScore).isEqualTo(expected);
	}

	private static Stream<Arguments> generatePlayerPagesAndExpectedResult() {
		return Stream.of(
				Arguments.of(Arrays.asList(231, 232), 12),
				Arguments.of(Arrays.asList(123, 124), 8),
				Arguments.of(Arrays.asList(399, 400), 243),
				Arguments.of(Arrays.asList(234, 245), 40),
				Arguments.of(Arrays.asList(111, 112), 4),
				Arguments.of(Arrays.asList(12, 13), 4),
				Arguments.of(Arrays.asList(55, 56), 30),
				Arguments.of(Arrays.asList(69, 70), 54),
				Arguments.of(Arrays.asList(101, 102), 3),
				Arguments.of(Arrays.asList(199, 200), 81)
		);
	}

	@ParameterizedTest(name = "Validation Test : {0} is invalid")
	@MethodSource("generatePlayerInvalidInput")
	void invalidInputTest(List<Integer> invalidPages) {
		// when : 플레이어가 고른 책의 페이지가 유효하지 않다면
		boolean invalidResult = Problem1.isInvalidInput(invalidPages);

		// then : INVALID 를 반환해야 함
		final boolean INVALID = true;
		assertThat(invalidResult).isEqualTo(INVALID);
	}

	private static Stream<Arguments> generatePlayerInvalidInput() {
		final boolean INVALID = true;

		return Stream.of(
				Arguments.of(Arrays.asList(1, 2), INVALID),
				Arguments.of(Arrays.asList(2, 3), INVALID),
				Arguments.of(Arrays.asList(132, 133), INVALID),
				Arguments.of(Arrays.asList(399, 400), INVALID),
				Arguments.of(Arrays.asList(0, 1), INVALID),
				Arguments.of(Arrays.asList(-123, -122), INVALID),
				Arguments.of(Arrays.asList(1111, 1112), INVALID),
				Arguments.of(Arrays.asList(3, 5), INVALID),
				Arguments.of(Arrays.asList(0), INVALID),
				Arguments.of(Arrays.asList(133), INVALID),
				Arguments.of(Arrays.asList(), INVALID)
		);
	}

	@ParameterizedTest(name = "Validation Test : {0} is valid")
	@MethodSource("generatePlayerValidInput")
	void validInputTest(List<Integer> validPages) {
		// when : 플레이어가 고른 책의 페이지가 유효하다면
		boolean validResult = Problem1.isInvalidInput(validPages);

		// then : VALID 를 반환해야 함
		final boolean VALID = false;
		assertThat(validResult).isEqualTo(VALID);
	}

	private static Stream<Arguments> generatePlayerValidInput() {
		final boolean VALID = false;

		return Stream.of(
				Arguments.of(Arrays.asList(97, 98), VALID),
				Arguments.of(Arrays.asList(243, 244), VALID),
				Arguments.of(Arrays.asList(123, 124), VALID),
				Arguments.of(Arrays.asList(99, 100), VALID)
		);
	}

	@ParameterizedTest(name = "MAIN TEST : ({0}, {1}) ==> {2}")
	@MethodSource("generatePlayersPagesAndExpectedResult")
	void testMainSolution(List<Integer> player1, List<Integer> player2, int expected) {
		// when : 플레이어가 게임을 시작했을 때
		int answer = Problem1.solution(player1, player2);

		// then : 게임 결과를 확인
		assertThat(answer).isEqualTo(expected);
	}

	private static Stream<Arguments> generatePlayersPagesAndExpectedResult() {
		// input : pobi, crong, result
		return Stream.of(
				Arguments.of(Arrays.asList(1, 2), Arrays.asList(3, 4), EXCEPTION_CASE),
				Arguments.of(Arrays.asList(3, 5), Arrays.asList(3, 4), EXCEPTION_CASE),
				Arguments.of(Arrays.asList(4, 5), Arrays.asList(3, 4), EXCEPTION_CASE),
				Arguments.of(Arrays.asList(3), Arrays.asList(3, 4), EXCEPTION_CASE),
				Arguments.of(Arrays.asList(123, 123), Arrays.asList(3, 4), EXCEPTION_CASE),
				Arguments.of(Arrays.asList(98, 97), Arrays.asList(3, 4), EXCEPTION_CASE),
				Arguments.of(Arrays.asList(-123, -122), Arrays.asList(3, 4), EXCEPTION_CASE),
				Arguments.of(Arrays.asList(3, 4), Arrays.asList(399, 400), EXCEPTION_CASE),
				Arguments.of(Arrays.asList(14313, 14314), Arrays.asList(111, 112), EXCEPTION_CASE),
				Arguments.of(Arrays.asList(-1341341, -1341342), Arrays.asList(3, 4), EXCEPTION_CASE),
				Arguments.of(Arrays.asList(1111, 1112), Arrays.asList(1111, 1112), EXCEPTION_CASE),
				Arguments.of(Arrays.asList(2, 3), Arrays.asList(2, 3), EXCEPTION_CASE),
				Arguments.of(Arrays.asList(3, 4), Arrays.asList(3, 4), DRAW),
				Arguments.of(Arrays.asList(111, 112), Arrays.asList(111, 112), DRAW),
				Arguments.of(Arrays.asList(123, 124), Arrays.asList(3, 4), POBI_WIN),
				Arguments.of(Arrays.asList(175, 176), Arrays.asList(223, 224), POBI_WIN),
				Arguments.of(Arrays.asList(321, 322), Arrays.asList(397, 398), CRONG_WIN),
				Arguments.of(Arrays.asList(133, 134), Arrays.asList(397, 398), CRONG_WIN)
		);
	}
}