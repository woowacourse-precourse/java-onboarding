package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> list = new ArrayList<>();
        TreeMap<String, Integer> score = new TreeMap<>();

        searchFriend(user, friends, list);

        return answer;
    }

    // 사용자와 친구인 사람의 목록을 작성하는 기능
    static void searchFriend(String user, List<List<String>> friends, List<String> list) {
        for (int i = 0; i < friends.size(); i++) {
            if (user.equals(friends.get(i).get(0))) {
                list.add(friends.get(i).get(1));
            }
            if (user.equals(friends.get(i).get(1))) {
                list.add(friends.get(i).get(0));
            }
        }
    }
}
