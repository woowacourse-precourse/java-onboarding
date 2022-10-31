package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CandidateIntroducer {

    private final String user;

    private final List<String> visitors;
    private final Map<String, List<String>> relationships;

    public CandidateIntroducer(String user, List<String> visitors, Map<String, List<String>> relationships) {
        this.user = user;
        this.visitors = visitors;
        this.relationships = relationships;
    }

    public Map<String, Friend> introduce() {
        Map<String, Friend> scores = new HashMap<>();
        List<String> userFriends = relationships.getOrDefault(user, new ArrayList<>());
        introduceKnowableFriends(userFriends, scores);
        introduceVisitors(userFriends, scores);
        return scores;
    }

    private void introduceKnowableFriends(List<String> userFriends, Map<String, Friend> scores) {
        for (String name : relationships.keySet()) {
            if (userFriends.contains(name)) {
                List<String> nameFriends = relationships.get(name);
                for (String nameFriend : nameFriends) {
                    if (nameFriend.equals(user) || userFriends.contains(nameFriend)) continue;
                    scores.put(nameFriend, scores.getOrDefault(nameFriend, new Friend(nameFriend)).addScore(10));
                }
            }
        }
    }

    private void introduceVisitors(List<String> userFriends, Map<String, Friend> scores) {
        for (String visitor : visitors) {
            if (userFriends.contains(visitor)) continue;
            scores.put(visitor, scores.getOrDefault(visitor, new Friend(visitor)).addScore(1));
        }
    }
}
