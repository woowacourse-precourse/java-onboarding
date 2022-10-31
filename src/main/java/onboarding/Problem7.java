package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, HashSet<String>> relation = new HashMap<>();
        HashMap<String, Integer> score = new HashMap<>();
        for (List<String> friend : friends) {
            findRelationship(relation, friend);
        }

        int count = 0;
        for (String name : relation.keySet()) {
            if(name.equals(user)) continue;
            count = relationshipScore(relation.get(name), relation.get(user));
            score.put(name, count*10);
        }
        //return answer;
    }
    public static void findRelationship(HashMap<String, HashSet<String>> relation, List<String> friends) {
        String friend1 = friends.get(0);
        String friend2 = friends.get(1);

        HashSet<String> friend_list = relation.getOrDefault(friend1, new HashSet<>());
        friend_list.add(friend2);
        friend_list = relation.getOrDefault(friend2, new HashSet<>());
        friend_list.add(friend1);
    }
    public static Integer relationshipScore(HashSet<String> friends, HashSet<String> userfriend) {
        int count = 0;
        for(String friend : friends) {
            if(userfriend.contains(friend)) count++;
        }
        return count;
    }
}
