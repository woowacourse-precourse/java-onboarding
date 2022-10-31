package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashSet<String> user_friend = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        // check friends of user
        for (int i = 0; i < friends.size(); ++i) {
            String A = friends.get(i).get(0);
            String B = friends.get(i).get(1);
            if (A == user)
                user_friend.add(B);
            else if (B == user)
                user_friend.add(A);
        }
        // check if have mutual friends with user
        for (int i = 0; i < friends.size(); ++i) {
            String A = friends.get(i).get(0);
            String B = friends.get(i).get(1);
            if (A == user || B == user)
                continue;
            if (user_friend.contains(A)) {
                if (map.containsKey(B))
                    map.put(B, map.get(B) + 10);
                else
                    map.put(B, 10);
            }
            if (user_friend.contains(B)) {
                if (map.containsKey(A))
                    map.put(A, map.get(A) + 10);
                else
                    map.put(A, 10);
            }
        }
        // check if visited user
        for (int i = 0; i < visitors.size(); ++i) {
            String curr = visitors.get(i);
            if (user_friend.contains(curr))
                continue;
            if (map.containsKey(curr))
                map.put(curr, map.get(curr) + 1);
            else
                map.put(curr, 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        // NOTE point should be descending order, hence k2.getValue() - k1.getValue()
        // while name should be ascending order, hence k1.getKey().compareTo(k2.getKey())
        list.sort((k1, k2) -> k2.getValue() - k1.getValue() == 0 ? k1.getKey().compareTo(k2.getKey()) : k2.getValue() - k1.getValue());
        for (int i = 0; i < 5; ++i) {
            if (i >= list.size())
                break;
            answer.add(list.get(i).getKey());
        }

        return answer;
    }
}
