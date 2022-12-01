package onboarding;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Problem3Test {
	@Test
	void 기능_테스트1() {
		int number = 22;
		int result = 6;
		assertThat(Problem3.solution(number)).isEqualTo(result);
	}

	@Test
	void 기능_테스트2() {
		int number = 39;
		int result = 22;
		assertThat(Problem3.solution(number)).isEqualTo(result);
	}
}
