package onboarding.problem7.domain;

public class Score {
    private static final int EACH_SCORE_OF_NUMBER_OF_FRIENDS_YOU_KNOW_TOGETHER = 10;
    
    private final int score;
    
    public Score() {
        this(0);
    }
    
    public Score(final int score) {
        this.score = score;
    }
    
    public Score addScoreOfNumberOfFriendsYouKnowTogether(final int numberOfFriendsYouKnowTogether) {
        return new Score(score + numberOfFriendsYouKnowTogether * EACH_SCORE_OF_NUMBER_OF_FRIENDS_YOU_KNOW_TOGETHER);
    }
    
    public Score increase() {
        return new Score(score + 1);
    }
    
    public boolean isNotZero() {
        return score != 0;
    }
    
    public int compareTo(final Score otherScore) {
        return Integer.compare(this.score, otherScore.score);
    }
    
    @Override
    public String toString() {
        return "Score{" +
                "score=" + score +
                '}';
    }
}
