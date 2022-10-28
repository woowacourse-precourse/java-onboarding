package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    static Map<String, Integer> recommendationScore = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
//        Map<String, Integer> recommendationScore = new HashMap<>();
        List<String> friendList = new ArrayList<>();

        for (List<String> friend : friends) {
            String friended = friend.get(0);
            String acquaintance = friend.get(1);

            verifiedFriends(friendList, friended);
            if(acquaintance.equals(user)) continue;
            scoreFriends(recommendationScore, acquaintance, 10);
        }


        for(String visitor : visitors) {
            if(friendList.contains(visitor)) continue;
            scoreFriends(recommendationScore, visitor, 1);
        }

        List<String> topFive = recommendationScore.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return topFive;

    }

    public static void verifiedFriends(List<String> friendList, String friended) {
        if(!friendList.contains(friended)) {
            friendList.add(friended);
        }
    }

    public static void scoreFriends(Map<String, Integer> recommendationScore, String acquaintance, int point) {
        if(recommendationScore.containsKey(acquaintance)) {
            int score = recommendationScore.get(acquaintance);
            recommendationScore.put(acquaintance, score + point);
            return;
        }
        recommendationScore.put(acquaintance, point);
    }
}
