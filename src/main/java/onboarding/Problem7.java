package onboarding;

import java.util.*;

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
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> mapListOfScores = new HashMap<>();
        int score = 0;
        Set<String> friendsSet = new HashSet<>();

        // friendsSet 해시set에 user의 친구 입력하기
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                String friendName = IsLeftOrRight(friends.get(i), user);
                friendsSet.add(friendName);
            }
        }

        System.out.println(friendsSet);

        // [shakevan, donut]
        for (int i = 0; i < friendsSet.size(); i++) {
            for (int j = 0; j < friends.size(); j++) {

            }
        }

        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> findFriendOfUser(String user, List<List<String>> friends) {
        List<String> listFriendOfUser = new ArrayList<>();


        return listFriendOfUser;
    }

    private static String IsLeftOrRight(List<String> friend, String user) {
        if (friend.get(0).equals(user)) {
            return friend.get(1);
        } else {
            return friend.get(0);
        }
    }
}
