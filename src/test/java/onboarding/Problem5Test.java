package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class Problem5Test {

	@Test
	void 입력_범위_맞는지() {
		assertThrows(IllegalArgumentException.class, () ->
			Problem5.solution(0));

		assertThrows(IllegalArgumentException.class, () ->
			Problem5.solution(1000001));
	}

	@Test
	void 올바른_입출력() {
		int money = 50_602;
		List<Integer> result = List.of(1, 0, 0, 0, 1, 1, 0, 0, 2);
		assertThat(Problem5.solution(money)).isEqualTo(result);

		money = 110_254;
		result = List.of(2, 1, 0, 0, 0, 2, 1, 0, 4);
		assertThat(Problem5.solution(money)).isEqualTo(result);
	}

}