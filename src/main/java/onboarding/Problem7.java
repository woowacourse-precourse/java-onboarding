package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    // 유저와 친구인 사람들 목록 구하기
    private static List<String> getFriendsList(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            List<String> friend = friends.get(i);
            if (friend.get(0).equals(user))
                friendList.add(friend.get(1));
            else if (friend.get(1).equals(user))
                friendList.add(friend.get(0));
        }
        return friendList;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendList = getFriendsList(user, friends);
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
