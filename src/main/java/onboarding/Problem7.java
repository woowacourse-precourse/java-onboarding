package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    static final int firstFriend = 0;
    static final int secondFriend = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        findUserFriends(user, friends);
        return answer;
    }

    //특정 사람과 친구인 사람 구하기
    public static List<String> findUserFriends(String user, List<List<String>> friendsList) {
        List<String> userFriendList = new ArrayList<>();
        String friends = "";

        for (int i = 0; i < friendsList.size(); i++) {
            friends = friendsList.get(i).get(firstFriend);
            if (user.equals(friendsList.get(i).get(firstFriend)))
                userFriendList.add(friends);
        }
        return userFriendList;
    }
}
