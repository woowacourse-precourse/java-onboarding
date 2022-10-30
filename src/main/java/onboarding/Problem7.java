package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, List<String>> friendsList;

        friendsList = getFriendsList(friends);
        return answer;
    }

    // 사용자들의 친구 목록 반환 함수
    static Map<String, List<String>> getFriendsList(List<List<String>> friends) {
        Map<String, List<String>> friendsList = new HashMap<>();
        List<String> list;

        for (int i = 0; i < friends.size(); i++) {
            for (int j: Arrays.asList(0, 1)) {
                if (!friendsList.containsKey(friends.get(i).get(j))) {
                    list = new ArrayList<>();
                } else {
                    list = friendsList.get(friends.get(i).get(j));
                }
                if (j == 0) {
                    list.add(friends.get(i).get(1));
                } else {
                    list.add(friends.get(i).get(0));
                }
                friendsList.put(friends.get(i).get(j), list);
            }
        }

        return friendsList;
    }

}
