package onboarding;

import java.util.*;

public class Problem7 {
    static List<String> userFriends = new ArrayList<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        makeUserFriends(user, friends);
        return answer;
    }
    private static void makeUserFriends(String user, List<List<String>> friends) {
        for (List<String> relation : friends) {
            if(Objects.equals(relation.get(0), user)) userFriends.add(relation.get(1));
            else if(Objects.equals(relation.get(1), user)) userFriends.add(relation.get(0));
        }
    }
}
