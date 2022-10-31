package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Score {

    private HashMap<String,Integer> score;
    private List<String> userFriends;

    public Score(HashMap<String,Integer> score, List<String> userFriends) {
        this.score = score;
        this.userFriends = userFriends;
    }


    public HashMap<String, Integer> getScore() {
        return score;
    }

    public List<String> getUserFriends() {
        return userFriends;
    }
}
