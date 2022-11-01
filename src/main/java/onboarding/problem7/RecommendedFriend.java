package onboarding.problem7;

public class RecommendedFriend implements Comparable<RecommendedFriend> {

	private final String name;
	private final int score;

	public RecommendedFriend(String name, int score) {
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
