package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, Integer> score_friend = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        
        List<String> user_friends = new ArrayList<>();

        for (List<String> relation : friends) {
            if(relation.get(0) == user) user_friends.add(relation.get(1));
            else if(relation.get(1) == user) user_friends.add(relation.get(0));
        }
        for (List<String> relation : friends) {
            String user1 = relation.get(0);
            String user2 = relation.get(1);

            if(user1 == user || user2 == user) continue;
            if(user_friends.contains(user1) && !user_friends.contains(user2)) {
                score_put(user2, 10);
            }
            else if(user_friends.contains(user2) && !user_friends.contains(user1)) {
                score_put(user1, 10);
            }
        }
        for (String new_visitor : visitors) {
            if(user_friends.contains(new_visitor)) {
                continue;
            }
            score_put(new_visitor, 1);
        }

        List<Map.Entry<String, Integer>> list_entry = new LinkedList<>(score_friend.entrySet());

        list_entry.sort(Map.Entry.comparingByKey());
        list_entry.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<String> list_result = new ArrayList<>();
        int cnt = 5;


        for(Map.Entry<String, Integer> entry : list_entry) {
            list_result.add(entry.getKey());
            cnt--;
            if(cnt <= 0) break;
        }
        return list_result;
    }

    static void score_put(String name, int score) {
        if(score_friend.containsKey(name))
            score += score_friend.get(name);
        score_friend.put(name, score);
    }
}
