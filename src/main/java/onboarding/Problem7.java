package onboarding;

import java.util.*;

public class Problem7 {
    static Set<String> friendSet = new HashSet<>();
    static Map<String, Integer> map = new HashMap<>();

    public static Set<String> userFriends (String user, List<List<String>> friends) {
        Set<String> userFriendSet = new HashSet<>();

        for(List<String> f : friends) {
            String f1 = f.get(0);
            String f2 = f.get(1);

            if(f1.equals(user)) {
                userFriendSet.add(f2);
            }else if(f2.equals(user)) {
                userFriendSet.add(f1);
            }
        }
        return userFriendSet;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        friendSet = userFriends(user, friends);

        for(List<String> friend : friends) {
            String f1 = friend.get(0);
            String f2 = friend.get(1);

            if(f1.equals(user) || f2.equals(user)) {
                continue;
            }
        }
        return answer;
    }
}
