package onboarding;

import java.util.*;

public class Problem7 {
    public static final int MAX_RECOMMENDATION = 5;
    public static HashMap<String, Integer> friendScore;
    public static List<String> answer;

    public static Comparator<? super Map.Entry<String, Integer>> customComparator = (Comparator<Map.Entry<String, Integer>>) (a, b) -> {
        if (a.getValue().equals(b.getValue()))
            return a.getKey().compareTo(b.getKey());
        else
            return b.getValue().compareTo(a.getValue());
    };

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        answer = new ArrayList<>();
        friendScore = new HashMap<>();

        countScoreByFriend(user, friends);
        countScoreByVisit(visitors);
        sortByScore();

        return answer.size() > MAX_RECOMMENDATION ? answer.subList(0,MAX_RECOMMENDATION) : answer;
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

    public static void sortByScore() {
        friendScore.entrySet().stream()
                .sorted(customComparator)
                .forEach(entry -> {
                    if(entry.getValue() > 0)
                        answer.add(entry.getKey());
                });
    }

    public static boolean isNew(String id) {
        return !friendScore.containsKey(id);
    }

    public static boolean isNotFriend(String id) {
        return friendScore.get(id) != 0;
    }
}
