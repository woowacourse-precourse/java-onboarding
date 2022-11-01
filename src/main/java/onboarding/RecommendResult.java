package onboarding;

public class RecommendResult {

    private final String name;
    private int recommendScore;

    public RecommendResult(String name, int recommendScore) {
        this.name = name;
        this.recommendScore = recommendScore;
    }

    public int getRecommendScore() {
        return recommendScore;
    }

    public String getName() {
        return name;
    }
}
