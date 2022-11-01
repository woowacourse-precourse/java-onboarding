package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // 사용자와 친구인 아이디를 구하는 기능
        List<String> userFriends = new ArrayList<>(); // 사용자의 친구들
        for (int i = 0; i < friends.size(); i++) {
            // 사용자에 관한 친구 정보일 경우
            if (friends.get(i).contains(user)) {
                String user1 = friends.get(i).get(0);
                String user2 = friends.get(i).get(1);

                if (user1.equals(user)) {
                    userFriends.add(user2);
                } else if (user2.equals(user)) {
                    userFriends.add(user1);
                }
            }
        }

        return answer;
    }
}
