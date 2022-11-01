package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        HashMap<String, List<String>> relation = new HashMap<>();
        HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();
        for (int i = 0; i < friends.size(); i++) {

            List<String> friend = friends.get(i);
            // 친구 관계 정리
            connectfriend(friend, relation);

            // 사람 별로 점수 정리 Map 생성
            makescoremap(friend, scoreMap);

        }

        List<String> answer = Collections.emptyList();
        return answer;
    }

    // 친구 관계 정리
    public static void connectfriend(List<String> friend, HashMap<String, List<String>> relation) {
        String friend1 = friend.get(0);
        String friend2 = friend.get(1);

        if (relation.containsKey(friend1)) {
            relation.get(friend1).add(friend2);
        } else {
            relation.put(friend1, new ArrayList<>());
            relation.get(friend1).add(friend2);
        }
        if (relation.containsKey(friend2)) {
            relation.get(friend2).add(friend1);
        } else {
            relation.put(friend2, new ArrayList<>());
            relation.get(friend2).add(friend1);
        }

    }

    // 사람 별로 점수 정리해줄 hashMap 생성
    public static void makescoremap(List<String> friend, HashMap<String, Integer> scoreMap) {
        String friend1 = friend.get(0);
        String friend2 = friend.get(1);

        if (!scoreMap.containsKey(friend1)) {
            scoreMap.put(friend1, 0);
        }
        if (!scoreMap.containsKey(friend2)) {
            scoreMap.put(friend2, 0);
        }


    }

}
