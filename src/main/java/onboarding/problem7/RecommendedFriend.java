package onboarding.problem7;

public class RecommendedFriend implements Comparable<RecommendedFriend> {

    private String name;
    private int score;

    public RecommendedFriend(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(RecommendedFriend other) {
        if (this.score < other.score) {
            return -1;
        } else if (this.score == other.score) {
            if (this.name.compareTo(other.name) > 0) {
                return -1;
            }
        }
        return 1;
    }
}
