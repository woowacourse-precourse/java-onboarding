package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    private static final int FROM = 0;
    private static final int TO = 1;

    private static Map<String, Set<String>> storeRelation(List<List<String>> friends) {
        Map<String, Set<String>> friendsByName = new HashMap<>();

        for (List<String> friend : friends) {
            String from = friend.get(FROM);
            String to = friend.get(TO);
            if (!friendsByName.containsKey(from)) {
                friendsByName.put(from, new HashSet<>());
            }
            if (!friendsByName.containsKey(to)) {
                friendsByName.put(to, new HashSet<>());
            }
            friendsByName.get(from).add(to);
            friendsByName.get(to).add(from);
        }
        return friendsByName;
    }
    private static Map<String, Integer> storeVisitorScore(List<String> visitors) {
        Map<String, Integer> visitorScore = new HashMap<>();

        for (String visitor : visitors) {
            if (!visitorScore.containsKey(visitor)) {
                visitorScore.put(visitor, 0);
            }
            int visitCnt = visitorScore.get(visitor);
            visitorScore.replace(visitor, visitCnt + 1);
        }
        return visitorScore;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, Set<String>> friendsByName = storeRelation(friends);
        List<String> userFriends = new ArrayList<>(friendsByName.get(friends));
        Map<String, Integer> visitorScore = storeVisitorScore(visitors);

        return answer;
    }
}
