package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Problem7 {

    static Map<String, Integer> resultScore = new HashMap<>(); // 추천 id별 점수 list
 
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // 유저 친구 list
        List<String> userFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) { // 앞에 user
                userFriends.add(friend.get(1));
            } else if (friend.get(1).equals(user)) { // 뒤에 user
                userFriends.add(friend.get(0));
            }
        }

        // 친구 점수 update (+10)
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user) || friend.get(1).equals(user)) {
                break;
            } else if (userFriends.contains(friend.get(0)) && !userFriends.contains(friend.get(1))) {
                score(friend.get(1), 10);
            } else if (userFriends.contains(friend.get(1)) && !userFriends.contains(friend.get(0))) {
                score(friend.get(0), 10);
            }
        }

        // 방문 점수 update (+1)
        for (String visitor : visitors) {
            if (userFriends.contains(visitor)) {
                continue;
            }
            score(visitor, 1);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(resultScore.entrySet());

        // 정렬
        entryList.sort(Entry.comparingByKey());
        entryList.sort(Entry.comparingByValue(Comparator.reverseOrder()));

        int count = 5;
        for (Entry<String, Integer> entry : entryList) {
            answer.add(entry.getKey());
            count--;
            if (count <= 0) { // 5개 까지만
                break;
            }
        }

        System.out.println(answer);
        return answer;
    }

    // 점수 update
    static void score(String name, int score) {
        if (resultScore.containsKey(name)) {
            score += resultScore.get(name); // 기존에 있는 경우 점수 update
        }
        resultScore.put(name, score); // 기존에 없는 경우
    }

    /*
    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko"));

        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        solution(user, friends, visitors);

    }

     */

}