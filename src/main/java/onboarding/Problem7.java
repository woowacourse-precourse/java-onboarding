package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {
    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        solution(user, friends, visitors);
    }

    private static final List<String> myFriends = new ArrayList<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        System.out.println(friendsListVerifier(user, friends));
        return null;
    }

    private static List<String> friendsListVerifier(String user, List<List<String>> friends) {
        saveMyFriends(user, friends);
        return myFriends;
    }

    private static void saveMyFriends(String myId, List<List<String>> friends) {
        for (List<String> users : friends) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).equals(myId)) {
                    if (i == 0) {
                        myFriends.add(users.get(1));
                    } else {
                        myFriends.add(users.get(0));
                    }
                }
            }
        }
    }
}
