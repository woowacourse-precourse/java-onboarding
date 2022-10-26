package onboarding.problem7.domain;

public class Score {
    private final int score;
    
    public Score() {
        this(0);
    }
    
    public Score(final int score) {
        this.score = score;
    }
    
    public Score addScoreOfNumberOfFriendsYouKnowTogether(final int numberOfFriendsYouKnowTogether) {
        return new Score(numberOfFriendsYouKnowTogether * 10);
    }
    
    public int getScore() {
        return score;
    }
}
