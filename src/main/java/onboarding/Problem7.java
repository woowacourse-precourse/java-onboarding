package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, Set<String>> friendshipGraph = new HashMap<>();
        initFriendshipGraph(friends, friendshipGraph);

        Map<String, Integer> visitorInfo = new HashMap<>();
        initVisitorInfo(visitors, visitorInfo, user, friendshipGraph);

        return answer;
    }

    /**
     * Function for friendshipGraph that represent all friendship as a graph
     * */
    private static void initFriendshipGraph(List<List<String>> friends, Map<String, Set<String>> friendshipGraph) {
        for (List<String> each : friends) {
            String person1 = each.get(0);
            String person2 = each.get(1);

            if (!friendshipGraph.containsKey(person1)) {
                friendshipGraph.put(person1, new HashSet<String>());
            }

            if (!friendshipGraph.containsKey(person2)) {
                friendshipGraph.put(person2, new HashSet<String>());
            }

            friendshipGraph.get(person1).add(person2);
            friendshipGraph.get(person2).add(person1);
        }
    }

    /**
     * Function for visitorInfo that mapping visitor name and visit nums
     * */
    private static void initVisitorInfo(List<String> visitors, Map<String, Integer> visitorInfo,
                                        String user, Map<String, Set<String>> friendshipGraph) {
        for (String visitor : visitors) {
            if (friendshipGraph.get(user).contains(visitor)) {
                continue;
            }
            if (visitorInfo.containsKey(visitor)) {
                visitorInfo.put(visitor, visitorInfo.get(visitor)+1);
            } else {
                visitorInfo.put(visitor, 1);
            }
        }
    }
}
