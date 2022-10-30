package problem7;

public class FriendCommendResponseDto {

    private final String userId;
    private final int score;

    public FriendCommendResponseDto(String userId, int score) {
        this.userId = userId;
        this.score = score;
    }

    public String getUserId() {
        return userId;
    }

    public int getScore() {
        return score;
    }
}
