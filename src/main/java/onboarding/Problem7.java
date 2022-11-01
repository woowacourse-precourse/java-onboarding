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

        return answer;
    }

}