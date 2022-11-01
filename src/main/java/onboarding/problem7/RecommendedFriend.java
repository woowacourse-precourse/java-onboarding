package onboarding.problem7;

public class RecommendedFriend implements Comparable<RecommendedFriend> {

    private final String name;
    private final int score;

    public RecommendedFriend(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(RecommendedFriend other) {
        if (isOtherScoreBig(this.score, other.score)) {
            return -1;
        } else if (scoreEq(this.score, other.score)) {
            if (isOtherNameFront(this.name, other.name)) {
                return -1;
            }
        }
        return 1;
    }

    private boolean isOtherScoreBig(int score, int otherScore) {
        return score < otherScore;
    }

    private boolean scoreEq(int score, int otherScore) {
        return score == otherScore;
    }

    private boolean isOtherNameFront(String name, String otherName) {
        return name.compareTo(otherName) > 0;
    }
}
