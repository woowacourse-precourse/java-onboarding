package onboarding;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.*;

class Problem5Test {

	@Nested
	class IntegrationTest {

		@Test
		void integrationTest1() {
			int money = 50_237;
			List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
			assertThat(Problem5.solution(money)).isEqualTo(result);
		}

		@Test
		void integrationTest2() {
			int money = 15_000;
			List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
			assertThat(Problem5.solution(money)).isEqualTo(result);
		}
	}
}
