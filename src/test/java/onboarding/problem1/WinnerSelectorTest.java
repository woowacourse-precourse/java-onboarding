package onboarding.problem1;

import static onboarding.problem1.ResultType.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("승자판별 기능 테스트")
class WinnerSelectorTest {
	WinnerSelector winnerSelector;

	@BeforeEach
	public void beforeEach() {
		winnerSelector = new WinnerSelectorImp();
	}

	@Test
	void 승자_판별() {
		// given
		int score1 = 100;
		int score2 = 105;

		// when
		ResultType result1 = winnerSelector.getWinner(score1, score2);
		ResultType result2 = winnerSelector.getWinner(score2, score1);
		ResultType result3 = winnerSelector.getWinner(score1, score1);

		// then
		assertThat(result1).isEqualTo(CRONG_WIN);
		assertThat(result2).isEqualTo(POBI_WIN);
		assertThat(result3).isEqualTo(DRAW);
	}
}