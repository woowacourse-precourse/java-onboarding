package onboarding;

import java.util.*;

public class Problem7 {
    private static HashMap<Integer, Integer> weight = new HashMap<>();
    private static HashMap<String, Integer> uniqueIDs = new HashMap<>();
    private static int forID = 0;
    private static int FRIEND_WEIGHT = 10;
    private static int VISITOR_WEIGHT = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    public static void addWeight(List<String> list, int WEIGHT) {
        for (int i = 0; i < list.size(); i++) {
            String user = list.get(i);
            int updatedValue = weight.get(user) + WEIGHT;
            int uniqueID = uniqueIDs.get(user);
            weight.put(uniqueID, updatedValue);
        }
    }
    public static List<String> getFriendsList(List<List<String>> friends, String user) {
        List<String> friendsList = Collections.emptyList();
        for (int i = 0; i < friends.size(); i++) {
            List<String> relation = friends.get(i);
            String friend1 = relation.get(0);
            String friend2 = relation.get(1);

            if (friend1.equals(user)) {
                friendsList.add(friend2);
            } else if (friend2.equals(user)) {
                friendsList.add(friend1);
            }
        }
        return friendsList;
    }
    public static void setDistinctID(List<String> friends) { // getDistinctFriends 이후 호출됨
        for (int i = 0; i < friends.size(); i++) {
            String name = friends.get(i);
            uniqueIDs.put(name, forID++);
        }
    }
    public static List<String> getDistinctFriends(List<List<String>> friends) {
        List<String> forJoin = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            List<String> relation = friends.get(i);
            forJoin.addAll(relation);
        }
        Set<String> distinctSet = new HashSet<>(forJoin);
        List<String> distinctList = new ArrayList<>(distinctSet);
        return distinctList;
    }
}
