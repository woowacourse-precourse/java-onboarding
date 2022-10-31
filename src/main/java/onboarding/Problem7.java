package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static Map<String, List<String>> friendList(List<List<String>> friends) {
        Map<String, List<String>> friendList = new HashMap<>();
        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            addFriend(friendList, friend1, friend2);
            addFriend(friendList, friend2, friend1);
        }
        return friendList;
    }

    private static void addFriend(Map<String, List<String>> friendList, String friend1, String friend2) {
        //friend값이 처음으로 리스트에 들어오면 초기화 진행
        if (!friendList.containsKey(friend1)) {
            friendList.put(friend1, new ArrayList<>());
            friendList.get(friend1).add(friend2);
            return;
        }
        friendList.get(friend1).add(friend2);
    }
}
