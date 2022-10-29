package onboarding.problem7.domain;

public class UserBasicInformation {
    private static final int DRAW_NUMBER = 0;
    
    private final String userName;
    private Score score;
    
    public UserBasicInformation(final String userName) {
        this.userName = userName;
        this.score = new Score();
    }
    
    public int compareTo(final UserBasicInformation otherUserBasicInformation) {
        if (isDraw(otherUserBasicInformation)) {
            return userName.compareTo(otherUserBasicInformation.userName);
        }
        
        return otherUserBasicInformation.score.compareTo(score);
    }
    
    private boolean isDraw(final UserBasicInformation otherUserBasicInformation) {
        return score.compareTo(otherUserBasicInformation.score) == DRAW_NUMBER;
    }
    
    public void addScoreOfNumberOfFriendsYouKnowTogether(final int numberOfFriendsYouKnowTogether) {
        this.score = score.addScoreOfNumberOfFriendsYouKnowTogether(numberOfFriendsYouKnowTogether);
    }
    
    public void scoreIncrease() {
        this.score = score.increase();
    }
    
    public boolean isScoreNotZero() {
        return score.isNotZero();
    }
    
    public String getUserName() {
        return userName;
    }
    
    @Override
    public String toString() {
        return "UserBasicInformation{" +
                "userName='" + userName + '\'' +
                ", score=" + score +
                '}';
    }
}
