package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> friendOfFriend = findRecommendFriend(user, friends);

        return answer;
    }

    private static List<String> findRecommendFriend(String user, List<List<String>> friends) {
        Map<String, List<String>> AdjacencyList = getAdjacencyList(friends);


    }

    private static Map<String, List<String>> getAdjacencyList(List<List<String>> friends) {
        Map<String, List<String>> resultAdjacencyList = new TreeMap<>();

        for(List<String> friend : friends) {
            String friendFirst = friend.get(0);
            String friendSecond = friend.get(1);

            if (!resultAdjacencyList.containsKey(friendFirst)) {
                resultAdjacencyList.put(friendFirst, new ArrayList<>());
            }
            resultAdjacencyList.get(friendFirst).add(friendSecond);

            if (!resultAdjacencyList.containsKey(friendFirst)) {
                resultAdjacencyList.put(friendFirst, new ArrayList<>());
            }
            resultAdjacencyList.get(friendSecond).add(friendFirst);
        }

        return resultAdjacencyList;
    }
}
