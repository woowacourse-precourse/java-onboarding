package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Problem7 {
    public final static int FRIEND_SCORE = 10;
    public final static int VISITED_SCORE = 1;

    public static Map<String, List<String>> getFriendMap(List<List<String>> friends) {
        Map<String, List<String>> result = new HashMap<>();

        for (List<String> names : friends) {
            for (int i = 0; i < names.size(); i++) {
                String name1 = names.get(i);
                for (int j = 0; j < names.size(); j++) {
                    if (i == j) {
                        continue;
                    }

                    String name2 = names.get(j);
                    if (result.containsKey(name1)) {
                        result.get(name1).add(name2);
                    }else{
                        result.put(name1, new ArrayList<String>(Arrays.asList(name2)));
                    }
                }
            }
        }

        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> totalFriendScores = new HashMap<>();
        Map<String, List<String>> friendMap = getFriendMap(friends);

        Function<String, Boolean> containUserFriends = (String other) -> (friendMap.get(user).contains(other));

        for (String friend : friendMap.get(user)) {
            for (String other : friendMap.get(friend)) {
                if (!other.equals(user) && !containUserFriends.apply(other)) {
                    if (totalFriendScores.containsKey(other)) {
                        totalFriendScores.put(other, totalFriendScores.get(other) + FRIEND_SCORE);
                    } else {
                        totalFriendScores.put(other, FRIEND_SCORE);
                    }
                }
            }
        }

        for (String visitor : visitors) {
            if (!visitor.equals(user) && !containUserFriends.apply(visitor)) {
                if (totalFriendScores.containsKey(visitor)) {
                    totalFriendScores.put(visitor, totalFriendScores.get(visitor) + VISITED_SCORE);
                } else {
                    totalFriendScores.put(visitor, VISITED_SCORE);
                }
            }
        }

        List<String> keys = new ArrayList<>(totalFriendScores.keySet());

        Collections.sort(keys, (String a, String b) -> {
            int aScore = totalFriendScores.get(a);
            int bScore = totalFriendScores.get(b);

            if (aScore != bScore) {
                return bScore - aScore;
            } else {
                return a.compareTo(b);
            }
        });

        for(int i = 0; i < keys.size() && i < 5; i++){
            answer.add(keys.get(i));
        }

        return answer;
    }
}
