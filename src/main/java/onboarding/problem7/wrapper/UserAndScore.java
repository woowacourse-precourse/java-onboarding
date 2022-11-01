package onboarding.problem7.wrapper;

public class UserAndScore {

    private final User newFriendUser;
    private final int score;

    public UserAndScore(User newFriendUser, int score) {
        this.newFriendUser = newFriendUser;
        this.score = score;
    }

    public String getUser() {
        return newFriendUser.getUserId();
    }

    public int getScore() {
        return score;
    }
}
