package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {

    static ArrayList<String> userFriend = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        getFriends(user, friends);


        return answer;
    }

    public static void getFriends(String user, List<List<String>> friends) {
        int index;
        List<String> friendsList;

        for (index = 0; index < friends.size(); index++) {

            friendsList = friends.get(index);

            if (friendsList.get(0).equals(user)) {
                userFriend.add(friendsList.get(1));
            }

            if (friendsList.get(1).equals(user)) {
                userFriend.add(friendsList.get(0));
            }
        }

    }

}
