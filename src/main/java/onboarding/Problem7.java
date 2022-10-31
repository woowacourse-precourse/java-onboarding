package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        makeFriendsGraph(friends);
        return answer;
    }

    private static Map<String, List<String>> makeFriendsGraph(List<List<String>> friends){
        Map<String, List<String>> friendsMap = new HashMap<>();

        for (List<String> relation : friends){
            List<String> relationship = friendsMap.getOrDefault(relation.get(0), new ArrayList<>());
            relationship.add(relation.get(1));
            friendsMap.put(relation.get(0),relationship);
            relationship = friendsMap.getOrDefault(relation.get(1), new ArrayList<>());
            relationship.add(relation.get(0));
            friendsMap.put(relation.get(1),relationship);
        }
        
        return friendsMap;
    }
}
