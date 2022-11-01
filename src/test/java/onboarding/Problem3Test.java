package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Problem3Test {
	@Test
	void 범위에_벗어난_숫자_입력() {

		assertThrows(IllegalArgumentException.class, ()->
			Problem3.solution(100000));

		assertThrows(IllegalArgumentException.class, ()->
			Problem3.solution(0));

		assertThrows(IllegalArgumentException.class, ()->
			Problem3.solution(-1));

		assertThrows(IllegalArgumentException.class, ()->
			Problem3.solution(-100));
	}

	@Test
	void case10000() {
		int number = 10000;
		int result = 12000;
		assertThat(Problem3.solution(number)).isEqualTo(result);
	}
}