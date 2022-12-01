package onboarding;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Problem3Test {
	@Test
	void case1() {
		int number = 22;
		int result = 6;
		assertThat(Problem3.solution(number)).isEqualTo(result);
	}

	@Test
	void case2() {
		int number = 39;
		int result = 22;
		assertThat(Problem3.solution(number)).isEqualTo(result);
	}
}
