package onboarding.friendrecommendationsystem.review;

public enum RecommendScore {
	KNOW_WITH_USER(10),
	VISITOR(1);

	private final int score;

	RecommendScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return this.score;
	}
}
