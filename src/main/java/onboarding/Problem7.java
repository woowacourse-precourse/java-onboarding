package onboarding;


import java.util.List;
import java.util.*;

public class Problem7 {
    static Map<String, Integer> friendScoreDict = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> userFriends = new ArrayList<>();

        for (List<String> friendRelations : friends) {
            if(friendRelations.get(0) == user) userFriends.add(friendRelations.get(1));
            else if(friendRelations.get(1) == user) userFriends.add(friendRelations.get(0));
        }


        for (List<String> friendRelations : friends) {
            String userA = friendRelations.get(0);
            String userB = friendRelations.get(1);
            if(userA == user || userB == user) continue;
            if(userFriends.contains(userA) && !userFriends.contains(userB)) {
                putScoreDict(userB, 10);
            }
            else if(userFriends.contains(userB) && !userFriends.contains(userA)) {
                putScoreDict(userA, 10);
            }
        }

        for (String visitor : visitors) {

            if(userFriends.contains(visitor)) continue;
            putScoreDict(visitor, 1);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(friendScoreDict.entrySet());

        entryList.sort(Map.Entry.comparingByKey());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int count = 5;
        List<String> resultList = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : entryList) {
            resultList.add(entry.getKey());
            count--;
            if(count <= 0) break;
        }
        return resultList;
    }


    static void putScoreDict(String name, int score) {
        if(friendScoreDict.containsKey(name))
            score += friendScoreDict.get(name);
        friendScoreDict.put(name, score);
    }
}
