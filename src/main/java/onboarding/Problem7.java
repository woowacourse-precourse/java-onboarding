package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Problem7 {

    static Map<String, Integer> recommendationScore = new HashMap<>();

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(List.of("donut", "andole"),
                                             List.of("donut", "jun"),
                                             List.of("donut", "mrko"),
                                             List.of("shakevan", "andole"),
                                             List.of("shakevan", "jun"),
                                             List.of("shakevan", "mrko"));

        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        System.out.println(solution(user, friends, visitors));

    }

    static void addScore(String name, int score) {
        if (recommendationScore.containsKey(name)) {
            score += recommendationScore.get(name);
        }
        recommendationScore.put(name, score);
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> userFriends = new ArrayList<>();       //유저의 친구 리스트
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                userFriends.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                userFriends.add(friend.get(0));
            }
        }

        for (List<String> friend : friends) {           //친구 점수 업데이트
            if (friend.get(0).equals(user) || friend.get(1).equals(user)) {
                break;
            } else if (userFriends.contains(friend.get(0)) && !userFriends.contains(friend.get(1))) {
                addScore(friend.get(1), 10);
            } else if (userFriends.contains(friend.get(1)) && !userFriends.contains(friend.get(0))) {
                addScore(friend.get(0), 10);
            }
        }

        for (String visitor : visitors) {       //방문 점수 업데이트
            if (userFriends.contains(visitor)) {
                continue;
            }
            addScore(visitor, 1);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(recommendationScore.entrySet());
        entryList.sort(Entry.comparingByKey());
        entryList.sort(Entry.comparingByValue(Comparator.reverseOrder()));
        int count = recommendationScore.size();
        for (Entry<String, Integer> entry : entryList) {
            answer.add(entry.getKey());
            count--;
            if (count <= 0) {
                break;
            }
        }
        return answer;
    }
}
