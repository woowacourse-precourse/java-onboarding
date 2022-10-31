package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        return answer;
    }


    // 유저 친구 목록
    public static List<String> userFriendsList(String user, List<List<String>> friends) { // 유저와 직접적인 친구관계
        List<String> userFriend = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                for (String name : friend) {
                    if (name.equals(user)) {
                        continue;
                    }
                    userFriend.add(name);
                }
            }
        }

        return userFriend;
    }




}
