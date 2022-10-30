package onboarding;

import java.util.*;

public class Problem7 {

    public static final int FRIEND_SCORE = 10;
    public static final int VISITOR_SCORE = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;

        ArrayList<String> withFriends = storeUserFriends(user, friends);

        return answer;
    }

    private static ArrayList<String> storeUserFriends(String user, List<List<String>> friends) {
        ArrayList<String> withFriends = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            List<String> friendList = friends.get(i);
            if (friendList.contains(user)) {
                for (int j = 0; j < friendList.size(); j++) {
                    String friend = friendList.get(j);
                    if (!user.equals(friend)) {
                        withFriends.add(friend);
                    }
                }
            }
        }
        return withFriends;
    }
}
