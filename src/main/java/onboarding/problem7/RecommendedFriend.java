package onboarding.problem7;

public class RecommendedFriend implements Comparable<RecommendedFriend> {

	private static final int SAME = 0;

	private final String name;
	private final Integer score;

	public RecommendedFriend(String name, Integer score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public int compareTo(RecommendedFriend other) {
		if (score.compareTo(other.score) == SAME) {
			return name.compareTo(other.name);
		}
		return score.compareTo(other.score);
	}

	public String getName() {
		return name;
	}
}
