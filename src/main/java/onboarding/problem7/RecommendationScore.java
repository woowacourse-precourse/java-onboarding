package onboarding.problem7;

public enum RecommendationScore {
    ACQUAINTANCE(10),
    VISITOR(1);
    private int score;

    RecommendationScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
