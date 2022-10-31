package onboarding;

import java.util.*;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {

        Map<String, Integer> user_score = new HashMap<>();
        Map<String, List<String>> user_friends = new HashMap<>();

        user_score.put("jun", 3);

        int val1 = user_score.getOrDefault("mrko", 1);
        int val2 = user_score.getOrDefault("jun", 4);

        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> array = new ArrayList<>();
        Problem7 pro = new Problem7();
        pro.setUserFriends(friends);

//    System.out.println(val1);
//    System.out.println(val2);

    }
}