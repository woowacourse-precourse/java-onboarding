package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

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
}
