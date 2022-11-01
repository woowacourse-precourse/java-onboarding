package onboarding.problem3.util;

import onboarding.problem3.SolveGame369;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Game369InputVailidatorTest {
	@Nested
	class Problem3Test {
		@Test
		void 입력_값의_범위_체크() {
			// give
			int numberPassed = 13;
			int numberFail = 123_456;
			// when
			boolean resultPassed = true;
			boolean resultFailed = true;
			// then
			assertThat(Game369InputVailidator.rangeValidator(numberPassed)).isEqualTo(resultPassed);
			assertThat(Game369InputVailidator.rangeValidator(numberFail)).isNotEqualTo(resultFailed);
		}

		@Test
		void 게임_입력_숫자_출현_횟수_카운트() {
			// give
			int gameNumber = 36093;
			SolveGame369 solveGame369 = new SolveGame369();

			// when
			int resultCount = 5;

			assertThat(solveGame369.count369OfSeparatedNum(gameNumber)).isEqualTo(resultCount);
		}
	}
}
