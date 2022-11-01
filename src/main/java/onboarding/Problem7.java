package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userFriendList = userFriends(user, friends);
        List<String> friendAndFriends = friendAndFriends(userFriendList, friends, user);
        return answer;
    }

    private static List<String> friendAndFriends(List<String> userFriendList, List<List<String>> friends, String user) {
        List<String> friendsAndFriends = new ArrayList<>();
        for (int i = 0; i < userFriendList.size(); i++) {
            for (int j = 0; j < friends.size(); j++) {
                if (friends.get(j).contains(userFriendList.get(i))) {
                    if (friends.get(j).get(1).equals(user)) {
                        continue;
                    }
                    System.out.println("friends.get(j) = " + friends.get(j));
                    friendsAndFriends.add(friends.get(j).get(1));
                }
            }
        }
        return friendsAndFriends;
    }

    private static List<String> userFriends(String user, List<List<String>> friends) {
        List<String> userFriendList = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                userFriendList.add(friends.get(i).get(0));
            }
        }
        return userFriendList;
    }
}
