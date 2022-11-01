package problem7;

import java.util.HashMap;

public class RecommendationDto {
    private HashMap<String, Integer> score;
    private HashMap<String, Integer> connection;
    private boolean[] isFriend;

    public RecommendationDto(HashMap<String, Integer> score, HashMap<String, Integer> connection, boolean[] isFriend) {
        this.score = score;
        this.connection = connection;
        this.isFriend = isFriend;
    }

    public HashMap<String, Integer> getScore() {
        return score;
    }

    public HashMap<String, Integer> getConnection() {
        return connection;
    }

    public boolean[] getIsFriend() {
        return isFriend;
    }
}
