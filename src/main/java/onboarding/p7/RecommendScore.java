package onboarding.p7;

public enum RecommendScore {
    ALONG_WITH(10),
    VISIT(1);
    private final int score;

    RecommendScore(int i) {
        score = i;
    }

    public int getScore() {
        return score;
    }
}
