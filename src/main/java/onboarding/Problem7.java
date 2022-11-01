package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> findUserFriends(String user, List<List<String>> friends) {
        List<String> userFriend = new ArrayList<>();
        for(List<String> friend :  friends) {
            if(friend.get(0) == user) {
                userFriend.add(friend.get(1));
            } else if(friend.get(1) == user) {
                userFriend.add(friend.get(0));
            }
        }
        return userFriend;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userFriend = findUserFriends(user, friends);
        System.out.println(userFriend);
        return answer;
    }

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
}
