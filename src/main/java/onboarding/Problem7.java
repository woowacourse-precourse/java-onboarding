package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    static final Map<String, List<String>> friendRelationGraph = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void makeFriendRelationGraph(List<List<String>> friends) {
        for (List<String> friend : friends) {
            addFriendRelationGraph(friend);
        }
    }

    private static void addFriendRelationGraph(List<String> friend) {
        String friendFrom = friend.get(0);
        String friendTo = friend.get(1);
		friendRelationGraph.putIfAbsent(friendFrom, new ArrayList<>());
		friendRelationGraph.putIfAbsent(friendTo, new ArrayList<>());
        friendRelationGraph.getOrDefault(friendFrom, new ArrayList<>())
				.add(friendTo);
		friendRelationGraph.getOrDefault(friendTo, new ArrayList<>())
				.add(friendFrom);
    }
}
