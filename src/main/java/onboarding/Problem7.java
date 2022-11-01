package onboarding;

import java.util.*;

public class Problem7 {
    static List<String> userFriends = new ArrayList<>();
    static Map<String, Integer> scoreDict = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        makeUserFriends(user, friends);
        checkFriends(user, friends);
        checkVisitors(visitors);
        List<Map.Entry<String, Integer>> entryList = sortScoreDict();
        return recommendPerson(entryList);
    }
    private static void makeUserFriends(String user, List<List<String>> friends) {
        for (List<String> relation : friends) {
            if(Objects.equals(relation.get(0), user)) userFriends.add(relation.get(1));
            else if(Objects.equals(relation.get(1), user)) userFriends.add(relation.get(0));
        }
    }
    private static void checkFriends(String user, List<List<String>> friends) {
        for (List<String> relation : friends) {
            String userA = relation.get(0);
            String userB = relation.get(1);
            if(isAlreadyFriend(user, userA, userB)) continue;
            if(isNewFriend(userA, userB)) {
                scorePerson(userB, 10);
            }
            else if(isNewFriend(userB, userA)) {
                scorePerson(userA, 10);
            }
        }
    }
    private static boolean isNewFriend(String userA, String userB) {
        return userFriends.contains(userA) && !userFriends.contains(userB);
    }

    private static boolean isAlreadyFriend(String user, String userA, String userB) {
        return Objects.equals(userA, user) || Objects.equals(userB, user);
    }
    static void scorePerson(String name, int score) {
        if(scoreDict.containsKey(name))
            score += scoreDict.get(name);
        scoreDict.put(name, score);
    }
    private static void checkVisitors(List<String> visitors) {
        for (String visitor : visitors) {
            if(userFriends.contains(visitor)) continue;
            scorePerson(visitor, 1);
        }
    }
    private static List<Map.Entry<String, Integer>> sortScoreDict() {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scoreDict.entrySet());
        entryList.sort(Map.Entry.comparingByKey());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return entryList;
    }
    private static List<String> recommendPerson(List<Map.Entry<String, Integer>> entryList) {
        int count = 5;
        List<String> resultList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entryList) {
            resultList.add(entry.getKey());
            count--;
            if(count <= 0) break;
        }
        return resultList;
    }
}
