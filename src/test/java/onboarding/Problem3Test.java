package onboarding;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Problem3Test {
	@ParameterizedTest(name = "''{0}'' contains {1} ''3,6,9''")
	@CsvSource(value = {"1:0", "123:1", "23:1", "33:2", "12413:1", "369:3", "612:1", "9546:2"}, delimiter = ':')
	void count369Test(String number, int expected) {
		// when : number 에 '3,6,9' 가 몇개인지 카운팅 할 때
		int countResult = Problem3.count369(number);

		// then : 카운팅 확인
		assertThat(countResult).isEqualTo(expected);
	}

	@ParameterizedTest(name = "MAIN TEST : count ''3,6,9'' range of [1 ~ {0}] is {1}")
	@CsvSource(value = {"10:3", "50:25", "423:347", "99:60", "10000:12000"}, delimiter = ':')
	void solutionTest(int number, int expected) {
		// when : 1 ~ number 까지의 숫자 중, '3,6,9' 의 총 개수를 구할 때
		int answer = Problem3.solution(number);

		// then : 3,6,9 개수 확인하기
		assertThat(answer).isEqualTo(expected);
	}
}