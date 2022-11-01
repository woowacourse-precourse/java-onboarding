package onboarding.problem7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ScoreBoard {
    private final Map<String, Integer> userScore = new HashMap<>();

    public void addPoint(String user, Point point) {
        if(!userScore.containsKey(user)) {
            userScore.put(user, Point.DEFAULT.getValue());
        }

        userScore.put(user, userScore.get(user) + point.getValue());
    }

    public Set<String> getKeySet() {
        return userScore.keySet();
    }

    public void addPoint(List<String> users, Point point) {
        users.forEach(user -> addPoint(user, point));
    }

    public void remove(String user) {
        userScore.remove(user);
    }
    public Integer getScore(String user) {
        return userScore.get(user);
    }
}
