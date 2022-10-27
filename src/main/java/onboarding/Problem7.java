package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Set<String> friendList = generateFriendList(friends);

        return answer;
    }

    private static Set<String> generateFriendList(List<List<String>> friends){
        Set<String> friendList = new HashSet<>();
        for (List<String> friend : friends) {
            friendList.add(friend.get(0));
        }
        return friendList;
    }
}
