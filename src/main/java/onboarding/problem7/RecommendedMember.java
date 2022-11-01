package onboarding.problem7;

public class RecommendedMember implements Comparable<RecommendedMember> {
    public String name;
    public int score;

    public RecommendedMember(String name, int score) {
        this.name = name;
        this.score = score;
    }
    @Override
    public int compareTo(RecommendedMember friend) {
        if (friend.score == this.score) {
            return this.name.compareTo(friend.name);
        }
        return friend.score - this.score;
    }
}
