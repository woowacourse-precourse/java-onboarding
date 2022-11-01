package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        return answer;
    }

    private static HashSet<String> userFriendsList(String user, List<List<String>> friends) {
        HashSet<String> userFriends = new HashSet<>();
        for(List<String> friend : friends) {
            if (friend.contains(user)) {
                userFriends.add(friend.get(1-friend.indexOf(user)));
            }
        }

        return userFriends;
    }

}

