package onboarding;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = findFriend(user, friends);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> findFriend (String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();

        for(List<String> friend : friends) {
            int friendIdx = friend.indexOf(user);
            if (friendIdx == 0) {
                friendList.add(friend.get(1));
            } else if (friendIdx == 1) {
                friendList.add(friend.get(0));
            }
        }
        return friendList;
    }
}
