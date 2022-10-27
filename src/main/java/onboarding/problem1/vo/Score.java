package onboarding.problem1.vo;

public class Score implements Comparable<Score> {
	private final Integer score;

	private Score(Integer score) {
		this.score = score;
	}

	public static Score of(Integer score) {
		return new Score(score);
	}

	@Override
	public int compareTo(Score anotherScore) {
		return Integer.compare(score, anotherScore.score);
	}

	public boolean isHigherThan(Score anotherScore) {
		return this.compareTo(anotherScore) > 0;
	}

	public boolean isLowerThan(Score anotherScore) {
		return this.compareTo(anotherScore) < 0;
	}
}
