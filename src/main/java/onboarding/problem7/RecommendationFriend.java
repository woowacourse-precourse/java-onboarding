package onboarding.problem7;


public class RecommendationFriend {

    private final int score;
    private final String id;

    public RecommendationFriend(String id, int score) {
        this.id = id;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getId() {
        return id;
    }
}
