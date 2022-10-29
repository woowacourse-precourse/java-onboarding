package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static Set<String> getUserFriends(String user, List<List<String>> friends){
        // 사용자의 친구를 찾아주는 메소드
        Set<String> userFriends = new HashSet<>();
        for (List<String> friend : friends){
            String leftFriend = friend.get(0);
            String rightFriend = friend.get(1);
            if (leftFriend.equals(user)){
                userFriends.add(rightFriend);
            }
            if (rightFriend.equals(user)){
                userFriends.add(leftFriend);
            }

        }
        return userFriends;
    }
}
