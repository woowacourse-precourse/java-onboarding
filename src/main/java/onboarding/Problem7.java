package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final Map<String, Integer> userscore = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        Set<String> userfriend = new HashSet<>();
       // Map<String, Integer> score = new HashMap<>();

        // 방문자 점수 만들기
        for (String visitor : visitors) {
            userscore.put(visitor, userscore.getOrDefault(visitor, 0) +1);
        }


        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                userfriend.addAll(friend);
            }
        }
        System.out.println(userfriend);
        for (List<String> friend : friends) {
            if (userfriend.contains(friend.get(0)) || userfriend.contains(friend.get(1))) {
                friendscore(friend.get(0), 10);
                friendscore(friend.get(1), 10);
            }
        }
        for (String friend : userfriend) {
            userscore.remove(friend);
        }





        for (String key : userscore.keySet()) {
            if (userscore.get(key) == 0) {
                userscore.remove(key);
            }
        }
        System.out.println(userscore);
        //System.out.println(score);

        answer = userscore.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
        /**
        answer = score.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
*/
        return answer;
    }

    public static void friendscore(String user, int score) {
        userscore.put(user, userscore.getOrDefault(user, 0) + score);
    }

}
