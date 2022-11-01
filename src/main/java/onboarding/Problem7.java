package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, HashSet<String>> relation = new HashMap<>();
        HashMap<String, Integer> friendscore = new HashMap<>();
        for (List<String> friend : friends) {
            findRelationship(relation, friend);
        }

        int count = 0;
        for (String name : relation.keySet()) {
            if(name.equals(user)) continue;
            if(relation.get(user).contains(name)) continue;
            count = relationshipScore(relation.get(name), relation.get(user));
            friendscore.put(name, count*10);
        }

        int visitscore = 0;
        for (String visitor : visitors) {
            if(relation.get(user).contains(visitor)) continue;
            visitscore = 0;
            if(friendscore.containsKey(visitor)) visitscore = friendscore.get(visitor);
            visitscore += 1;
            friendscore.put(visitor, visitscore);
        }

        return friendscore.entrySet().stream().
                sorted(Collections
                        .reverseOrder(Map.Entry.<String, Integer>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey())).
                limit(5).map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    public static void findRelationship(HashMap<String, HashSet<String>> relation, List<String> friends) {
        String friend1 = friends.get(0);
        String friend2 = friends.get(1);

        HashSet<String> friend_list = relation.getOrDefault(friend1, new HashSet<>());
        friend_list.add(friend2);
        relation.put(friend1, friend_list);

        friend_list = relation.getOrDefault(friend2, new HashSet<>());
        friend_list.add(friend1);
        relation.put(friend2, friend_list);
    }
    public static Integer relationshipScore(HashSet<String> friends, HashSet<String> userfriend) {
        int count = 0;
        for(String friend : friends) {
            if(userfriend.contains(friend)) count++;
        }
        return count;
    }
}
