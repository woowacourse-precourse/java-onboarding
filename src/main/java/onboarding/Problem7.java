package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, List<String>> friendsMap = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        return answer;
    }
    private static void inputNameToMap(String user, List<List<String>> friends) {
        List<String> userFriend = new ArrayList<>();
        for(List<String> friend : friends) {
            if(friend.contains(user)) {
                for (String name : friend) {
                    if (name.equals(friend.get(0))) {
                        userFriend.add(friend.get(1));
                    } else {
                        userFriend.add(friend.get(0));
                    }
                }
            }
        }
    }

}