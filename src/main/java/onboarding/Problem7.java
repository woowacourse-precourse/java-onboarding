package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        return answer;
    }


    // 유저 친구 목록
    public static List<String> friendsList(List<List<String>> friends) { // friends 목록 친구들 list만들기
        List<String> list = new ArrayList<>();

        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);

            if (list.contains(friendA)) {
                continue;
            } else
                list.add(friendA);

            if (list.contains(friendB)) {
                continue;
            } else
                list.add(friendB);
        }

        return list;
    }
}
