package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // List<String> answer = Collections.emptyList();
        List<String> answer = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();

        // 사용자의 친구 리스트 저장하기
        for (int i=0; i<friends.size(); i++) {
            if (friends.get(i).get(0).equals(user) && !userFriends.contains(friends.get(i).get(1))) {
                userFriends.add(friends.get(i).get(1));
            }

            if (friends.get(i).get(1).equals(user) && !userFriends.contains(friends.get(i).get(0))) {
                userFriends.add(friends.get(i).get(0));
            }
        }

        System.out.println(userFriends);

        return answer;
    }
}
