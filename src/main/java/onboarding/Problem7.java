package onboarding;

import java.util.*;

public class Problem7 {

    static HashSet<String> directFriends = new HashSet<>(); // 직접 친구 리스트
    static Map<String, Integer> friendsScoreList = new HashMap<>(); // 친구/점수 리스트

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        // 1. 직접 친구(아는 친구X) 리스트 초기화
        directFriends = getDirectFriends(user, friends);

        return answer;
    }

    // 1. 직접 친구(아는 친구X) 리스트 초기화
    static HashSet<String> getDirectFriends(String user, List<List<String>> friends){
        HashSet<String> directFriends = new HashSet<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user))  directFriends.add(friend.get(1));
            if (friend.get(1).equals(user))  directFriends.add(friend.get(0));
        }

        return directFriends;
    }
}
