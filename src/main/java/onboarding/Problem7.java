package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    // user의 친구 찾기
    public static List<String> findUserFriend(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                for (String name : friends.get(i)) {
                    if (!name.equals(user)) friendList.add(name);
                }
            }
        }
        return friendList;
    }
    // user의 친구의 친구찾기
    public static List<String> findLinkedFriends(String user, List<List<String>> friends, List<String> friendList) {
        List<String> linkedFriends = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (friendList.contains(friends.get(i).get(0)) || friendList.contains(friends.get(i).get(1))) {
                for (String name : friends.get(i)) {
                    if (!name.equals(user) && !friendList.contains(name)) {
                        linkedFriends.add(name);
                    }
                }
            }
        }
        return linkedFriends;
    }



}