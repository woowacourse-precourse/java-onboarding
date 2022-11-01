package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, List<String>> relationMap = getRelationMap(friends);
        Map<String, Integer> userPoints = new HashMap<>();

        caculateRelationPoints(user, relationMap, userPoints);
        caculateVisitPoints(user, visitors, userPoints);

        answer = getRecommendedFriends(user, relationMap, userPoints);
        return answer;
    }


    private static HashMap<String, List<String>> getRelationMap(List<List<String>> friends) {
        HashMap<String, List<String>> relationMap = new HashMap<String, List<String>>();

        for (List<String> relation : friends) {
            String user1 = relation.get(0);
            String user2 = relation.get(1);

            if (!relationMap.containsKey(user1)) relationMap.put(user1, new ArrayList<>());
            if (!relationMap.containsKey(user2)) relationMap.put(user2, new ArrayList<>());

            relationMap.get(user1).add(user2);
            relationMap.get(user2).add(user1);
        }
        return relationMap;
    }


    private static void caculateRelationPoints(
            String user,
            Map<String, List<String>> relationMap,
            Map<String, Integer> userPoints
    ) {
        Queue<String> queue = new LinkedList<>();

        for (String friend : relationMap.get(user)) {
            for (String nextFriend: relationMap.get(friend)){
                if (!nextFriend.equals(user)) queue.add(nextFriend);
            }
        }

        while (!queue.isEmpty()) {
            String recommendedFriend = queue.poll();
            userPoints.put(recommendedFriend, userPoints.getOrDefault(recommendedFriend, 0)+10);
        }
    }


    private static void caculateVisitPoints(
            String user,
            List<String> visitors,
            Map<String, Integer> userPoints
    ) {
        for (String visitor: visitors) {
            if (!visitor.equals(user)) userPoints.put(visitor, userPoints.getOrDefault(visitor, 0)+1);
        }
    }


    private static List<String> getUsersOrderByPoints(Map<String, Integer> userPoints){
        List<String> userOrderByPoints = new ArrayList<>(userPoints.keySet());

        userOrderByPoints.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return userPoints.get(o2).compareTo(userPoints.get(o1));
            }
        });

        return userOrderByPoints;
    }


    private static List<String> getRecommendedFriends(
            String user,
            Map<String, List<String>> relationMap,
            Map<String, Integer> userPoints
    ) {
        List<String> allRecommendedFriends = getUsersOrderByPoints(userPoints);
        List<String> recommendedFriends = new ArrayList<>();

        for (String friend : allRecommendedFriends) {
            if (!relationMap.get(user).contains(friend) && user!=friend) recommendedFriends.add(friend);
            if (recommendedFriends.size() >= 5) break;
        }

        return recommendedFriends;
    }
}
