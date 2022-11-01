package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> findMyFriends(String user, List<List<String>> AllFriends) {
        List<String> myFriends = new ArrayList<>();
        // 전체 친구들 중에 user의 친구 찾기
        AllFriends.forEach(friend -> {
            if (user.equals(friend.get(1))) {
                myFriends.add(friend.get(0));
            }
        });
        return myFriends;
    }

}
