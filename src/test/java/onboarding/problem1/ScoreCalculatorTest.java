package onboarding.problem1;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("점수계산 기능 테스트")
class ScoreCalculatorTest {
	ScoreCalculator scoreCalculator;

	@BeforeEach
	public void beforeEach() {
		scoreCalculator = new ScoreCalculator();
	}

	@Test
	void 점수_계산() {
		// given
		List<Integer> user1 = Arrays.asList(101, 102);
		List<Integer> user2 = Arrays.asList(97, 98);
		List<Integer> user3 = Arrays.asList(9, 10);
		// when
		int score1 = scoreCalculator.getScore(user1);
		int score2 = scoreCalculator.getScore(user2);
		int score3 = scoreCalculator.getScore(user3);

		// then
		assertThat(score1).isEqualTo(3);
		assertThat(score2).isEqualTo(72);
		assertThat(score3).isEqualTo(9);
	}

	@Test
	void 점수_비교() {
		// given
		List<Integer> user1 = Arrays.asList(97, 98);
		List<Integer> user2 = Arrays.asList(197, 198);
		List<Integer> user3 = Arrays.asList(131, 132);
		List<Integer> user4 = Arrays.asList(211, 212);

		// when
		int score1 = scoreCalculator.getScore(user1);
		int score2 = scoreCalculator.getScore(user2);
		int score3 = scoreCalculator.getScore(user3);
		int score4 = scoreCalculator.getScore(user4);

		// then
		assertThat(score1).isEqualTo(score2);
		assertThat(score3).isGreaterThan(score4);
	}
}