package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Set<String> friendList = new HashSet<>();

        // 친구목록 찾아오기(초기화)
        initializeFriendList(user, friendList, friends);

        return answer;
    }

    public static void initializeFriendList(String user, Set<String> friendList, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                if (friend.get(0).equals(user)) {
                    friendList.add(friend.get(1));
                } else {
                    friendList.add(friend.get(0));
                }
            }
        }
    }

}
