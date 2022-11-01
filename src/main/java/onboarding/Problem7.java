package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashMap<String, Integer> refArr = new HashMap<>();
        List<String> friendArr = new ArrayList<>();
        String userfriend;
        int score =0;

        // 1. user의 친구 찾기
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                friendArr.add(friend.get(0));
            }
        }
        return answer;
    }
}
