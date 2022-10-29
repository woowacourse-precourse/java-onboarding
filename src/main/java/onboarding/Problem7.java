package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }


    public static String returnFriendName(List<String> friend, String myName) {

        for (int i = 0; i < 2; i++) {
            if (!(friend.get(i).equals(myName))) {
                return friend.get(i);
            }
        }

        throw new RuntimeException("본인 이름 없음");
    }

    public static List<String> makeFriendsList(String user, List<List<String>> friends) {
        ArrayList<String> friendsList = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            List<String> freind = friends.get(i);

            if (freind.contains(user)) {
                friendsList.add(returnFriendName(freind, user));
            }
        }
        return friendsList;
    }

}
