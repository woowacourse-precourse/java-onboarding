package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    // main method for testing purposes
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
        System.out.println(solution(user, friends, visitors));

    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> usersFriends = new ArrayList<>();
        HashMap<String, Integer> candidates = new HashMap<>();

        // 유저의 친구 List 완성
        for (List<String> strings : friends) {
            if (strings.get(0).equals(user))
                usersFriends.add(strings.get(1));
            else if (strings.get(1).equals(user))
                usersFriends.add(strings.get(0));
        }

        // 유저의 친구의 친구 List 완성, 친구의 친구들 (candidates) 의 점수 + 10
        for (String usersFriend : usersFriends) {
            for (List<String> friend : friends) {
                if (!friend.contains(user) && friend.contains(usersFriend)) {
                    String notFriend = friend.get(friend.indexOf(usersFriend) == 1 ? 0 : 1);
                    if (!candidates.containsKey(notFriend))
                        candidates.put(notFriend, 10);
                    else
                        candidates.put(notFriend, candidates.get(notFriend) + 10);
                }
            }
        }

        // visitor 까지 포함하여 candidates  완성
        for (String visitor : visitors) {
            if (!usersFriends.contains(visitor)) {
                if (!candidates.containsKey(visitor))
                    candidates.put(visitor, 1);
                else
                    candidates.put(visitor, candidates.get(visitor) + 1);
            }
        }

        List<String> answer = new ArrayList<>();

        // Value 기준으로 내림차순 정렬
        List<String> keySet = new ArrayList<>(candidates.keySet());
        keySet.sort((o1, o2) -> candidates.get(o2) - candidates.get(o1));

        for (String key : keySet) {
            if (answer.size() == 5)
                break;
            answer.add(key);
        }
        return answer;
    }
}
