package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

    static ArrayList<String> makeFriendList(String user, List<List<String>> friends) {
        ArrayList<String> friendsOfUser = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                String friendName = addFriends(user, friend);
                friendsOfUser.add(friendName);
            }
        }

        return friendsOfUser;
    }

    static String addFriends(String user, List<String> friend) {
        if (friend.get(0).equals(user)) {
            return friend.get(1);
        }
        return friend.get(0);
    }

    static ArrayList<String> findCommonUser(String user, ArrayList<String> friendsOfUser, List<List<String>> friends) {
        ArrayList<String> commonFriend = new ArrayList<>();
        ArrayList<String> realCommonFriend = new ArrayList<>();

        for (List<String> friend : friends) {
            for (String myFriend : friendsOfUser) {
                commonFriend.add(addFriends(myFriend, friend));
            }
        }

        for (int i = 0; i < commonFriend.size(); i++) {
            Collections.sort(commonFriend);
            if (!commonFriend.get(i).equals(user)) {
                if (!realCommonFriend.contains(commonFriend.get(i))) {
                    realCommonFriend.add(commonFriend.get(i));
                }
            }
        }

        return realCommonFriend;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, Integer> score = new HashMap<>();

        ArrayList<String> friendsOfUser = makeFriendList(user, friends);
        ArrayList<String> commonFriend = findCommonUser(user, friendsOfUser, friends);

        return answer;
    }
}
