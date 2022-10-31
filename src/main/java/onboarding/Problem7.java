package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendsScore = new HashMap<>();
        List<String> exceptNames = new ArrayList<>();

    }



    private static Integer countScore(Map<String, Integer> friendsScore, String friendName, int score) {
        return friendsScore.put(friendName, friendsScore.getOrDefault(friendName, 0) + score);
    }

    private static boolean isAlreadyFriends(List<String> exceptNames, List<String> friend){
        return exceptNames.contains(friend.get(0)) || exceptNames.contains(friend.get(1));
    }
    private static boolean isAlreadyFriends(List<String> exceptNames, String friend){
        return exceptNames.contains(friend);
    }
}
