package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    private static Set<String> findUserFriends(String user, List<List<String>> friends) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++)
                if (friends.get(i).get(j) == user) {
                    result.add(friends.get(i).get(1 - j));
                }
        }
        return result;
    }
    private static HashMap<String, Integer> findNotUserFriends(String user, List<List<String>> friends, Set<String> user_friends) {
        HashMap<String, Integer> result = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            String first = friends.get(i).get(0);
            String second = friends.get(i).get(1);
            if (first == user || second == user || user_friends.isEmpty())
                continue;
            if (!user_friends.contains(first) && !user_friends.contains(second))
                continue;
            if(!user_friends.contains(first))
                result.put(first, result.getOrDefault(first, 0) + 10);
            if(!user_friends.contains(second))
                result.put(second, result.getOrDefault(second, 0) + 10);
        }
        return result;
    }
}
