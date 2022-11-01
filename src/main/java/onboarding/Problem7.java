package onboarding;

import java.util.*;

public class Problem7 {
    public static HashMap<String, Integer> friendScore;
    public static List<String> answer;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        answer = new ArrayList<>();
        friendScore = new HashMap<>();

        countScoreByFriend(user, friends);
        countScoreByVisit(visitors);

        return answer;
    }

    public static void countScoreByFriend(String user, List<List<String>> friends) {
        for(List<String> friendInfo : friends) {
            String friend = friendInfo.get(0);
            String candidate = friendInfo.get(1);

            friendScore.putIfAbsent(friend, 0);
            if(!candidate.equals(user)){
                friendScore.put(candidate, friendScore.getOrDefault(candidate, 0) + 10);
            }
        }
    }

    public static void countScoreByVisit(List<String> visitors) {
        for(String visitor : visitors) {
            if(isNew(visitor) || isNotFriend(visitor)){
                friendScore.put(visitor, friendScore.getOrDefault(visitor, 0) + 1);
            }
        }
    }

    public static boolean isNew(String id) {
        return !friendScore.containsKey(id);
    }

    public static boolean isNotFriend(String id) {
        return friendScore.get(id) != 0;
    }
}
