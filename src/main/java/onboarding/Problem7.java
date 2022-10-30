package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static HashMap createFriendsList(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> members = new HashMap<String, Integer>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                String name = friends.get(i).get(j);
                members.put(name, 0);
            }
        }
        for (int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);
            members.put(visitors.get(i), 0);
        }
        members.remove(user);
        return members;
    }
}
