package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {

    private static Map<String, List<String>> friendGraph;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        initFriendGraph(friends);

        return null;
    }

    private static void initFriendGraph(List<List<String>> friends) {
        friendGraph = new HashMap<>();

        for (List<String> relation : friends) {
            String friend1 = relation.get(0);
            String friend2 = relation.get(1);

            List<String> friend1List = friendGraph.getOrDefault(friend1, new ArrayList<>());
            if (friend1List.isEmpty()) {
                friendGraph.put(friend1, friend1List);
            }
            friend1List.add(friend2);

            List<String> friend2List = friendGraph.getOrDefault(friend2, new ArrayList<>());
            if (friend2List.isEmpty()) {
                friendGraph.put(friend2, friend2List);
            }
            friend2List.add(friend1);
        }
    }
}
