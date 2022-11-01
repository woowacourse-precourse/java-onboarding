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
		if (score == other.score) {
			return other.name.compareTo(name);
		}
		return Integer.compare(score, other.score);
	}

	public String getName() {
		return name;
	}
}
