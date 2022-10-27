package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, List<String>> relationMap = new HashMap<>();

        for (List<String> relation : friends) {
            if (relationMap.get(relation.get(0)) == null) {
                relationMap.put(relation.get(0), new ArrayList<>());
            }
            if (relationMap.get(relation.get(1)) == null) {
                relationMap.put(relation.get(1), new ArrayList<>());
            }
        }
        for (List<String> relation : friends) {
            relationMap.get(relation.get(0)).add(relation.get(1));
            relationMap.get(relation.get(1)).add(relation.get(0));
        }

        List<String> myFriends = relationMap.get(user);
        HashMap<String, Integer> scoreMap = new HashMap<>();

        for (String name : relationMap.keySet()) {
            if (name.equals(user) || myFriends.contains(name)) continue;
            
            List<String> relation = relationMap.get(name);
            for (String theirName : relation) {
                if (myFriends.contains(theirName)) {
                    scoreMap.put(name, scoreMap.getOrDefault(name, 0)+10);
                }
            }
        }

        for (String name : visitors) {
            if (!myFriends.contains(name)) {
                scoreMap.put(name, scoreMap.getOrDefault(name, 0)+1);
            }
        }

        return scoreMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }
}

