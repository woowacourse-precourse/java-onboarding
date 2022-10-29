package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("mrko", "donut"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        System.out.println(solution(user,friends,visitors));
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriend = new ArrayList<>();
        for (List<String> f : friends) {
            if (f.indexOf(user) == 1) {
                userFriend.add(f.get(0));
            }else if (f.indexOf(user) == 0) {
                userFriend.add(f.get(1));
            }

        }
        System.out.println(userFriend);


        List<String> answer = Collections.emptyList();
        return answer;
    }
}
