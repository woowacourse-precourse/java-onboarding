package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static Map<String, Integer> friendCandidate = new HashMap<>();
    private static Set<String> oldFriend = new HashSet<>();
    private static List<List<String>> friendData;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = getRecomendedFriends(user,friends,visitors);
        return answer;
    }

    private static List<String> getRecomendedFriends(String user, List<List<String>> friends, List<String> visitors){
        oldFriend.add(user);
        friendData=friends;
        List<String> olderFriends = getFriendOfUser(user);

    }

}
