package onboarding.problem1.vo;

/**
 * 점수 값을 보관하고 있는 VO 클래스입니다.
 * @author BackFoxx
 */
public class Score implements Comparable<Score> {
	private final Integer score;

	private Score(Integer score) {
		this.score = score;
	}

	/**
	 * 인자로 들어온 값을 score 로 하는 Score 객체를 만드는 정적 팩토리 메소드입니다.
	 */
	public static Score of(Integer score) {
		return new Score(score);
	}

	@Override
	public int compareTo(Score anotherScore) {
		return Integer.compare(score, anotherScore.score);
	}

	/**
	 * 해당 메소드를 호출한 Score 값이 인자로 들어온 Score 값보다 높은 지 검증하는 메소드입니다.
	 */
	public boolean isHigherThan(Score anotherScore) {
		return this.compareTo(anotherScore) > 0;
	}

	/**
	 * 해당 메소드를 호출한 Score 값이 인자로 들어온 Score 값보다 낮은 지 검증하는 메소드입니다.
	 */
	public boolean isLowerThan(Score anotherScore) {
		return this.compareTo(anotherScore) < 0;
	}
}
