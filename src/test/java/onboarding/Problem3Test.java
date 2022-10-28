package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Problem3Test {

	@Test
	void 입력이_범위에_맞지않는_수() {
		assertThrows(IllegalArgumentException.class, () ->
			Problem3.solution(10001));

		assertThrows(IllegalArgumentException.class, () ->
			Problem3.solution(0));

		assertThrows(IllegalArgumentException.class, () ->
			Problem3.solution(-10));

		assertThrows(IllegalArgumentException.class, () ->
			Problem3.solution(20212));
	}

	@Test
	void 올바른_결과() {
		assertThat(Problem3.solution(40)).isEqualTo(22);
		assertThat(Problem3.solution(36)).isEqualTo(18);
	}
}
