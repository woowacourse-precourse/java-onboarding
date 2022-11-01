package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashMap<String, Integer> friendCandidateHashMap = new HashMap<>();
        setFriendScoreOfUser(friendCandidateHashMap, friends, user);


        return answer;
    }

    private static void setFriendScoreOfUser(HashMap<String, Integer> friendCandidateHashMap, List<List<String>> friends, String user) {
        List<String> friendsOfUser = getFriendOfUser(friends, user);
        List<String> friendsOfFriendOfUser = getFriendOfFriendOfUser(friendsOfUser, friends, user);
        for (String friendOfFriendOfUser : friendsOfFriendOfUser) {
            friendCandidateHashMap.put(friendOfFriendOfUser, friendCandidateHashMap.containsKey("friendOfFriendOfUser") ? friendCandidateHashMap.get(friendOfFriendOfUser) + 10 : 10);
        }
    }

    private static List<String> getFriendOfUser(List<List<String>> friends, String user) {
    }

    private static List<String> getFriendOfFriendOfUser(List<String> friendsOfUser, List<List<String>> friends, String user) {
    }
}
