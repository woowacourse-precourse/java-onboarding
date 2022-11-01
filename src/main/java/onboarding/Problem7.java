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

        return answer;
    }

    // 점수 update
    static void score(String name, int score) {
        if (resultScore.containsKey(name)) {
            score += resultScore.get(name); // 기존에 있는 경우 점수 update
        }
        resultScore.put(name, score); // 기존에 없는 경우
    }
}