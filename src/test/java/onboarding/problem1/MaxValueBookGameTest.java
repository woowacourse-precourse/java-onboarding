package onboarding.problem1;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MaxValueBookGameTest {
	private static MaxValueBookGame maxValueBookGame;

	@BeforeAll
	public static void initMaxValueBookGame() {
		maxValueBookGame = new MaxValueBookGame();
	}

	@Nested
	class ProblemTest {
		@Test
		void 특정_페이지의_각_자리_숫자를_모두_더하기() {
			List<Integer> pobi = List.of(97, 98);

			int result = 17;
			assertThat(maxValueBookGame.sumSeparatorNum(pobi.get(1))).isEqualTo(result);
		}

		@Test
		void 특정_페이지의_각_자리_숫자를_모두_곱하기() {
			List<Integer> pobi = List.of(197, 198);

			int result = 63;
			assertThat(maxValueBookGame.multiSeparatorNum(pobi.get(0))).isEqualTo(result);
		}

		@Test
		void 두_숫자중_큰_값_구하기() {
			int  sumSeparatorNum = 17;
			int  multiSeparatorNum = 63;

			int result = 63;
			assertThat(maxValueBookGame.returnMaxValue(sumSeparatorNum, multiSeparatorNum)).isEqualTo(result);
		}
	}
}
