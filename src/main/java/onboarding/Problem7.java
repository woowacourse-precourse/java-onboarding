package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();


        return answer;
    }

    public static HashMap<String, HashSet<String>> makeFriend (List<List<String>> friends){
        HashMap<String, HashSet<String>> friendMap = new HashMap<>();
        for (List<String> friendRelation : friends){
            String user1 = friendRelation.get(0);
            String user2 = friendRelation.get(1);
            if (friendMap.containsKey(user1)){
                friendMap.get(user1).add(user2);
            }
            else {
                friendMap.put(user1, new HashSet<>());
                friendMap.get(user1).add(user2);
            }

            if (friendMap.containsKey(user2)){
                friendMap.get(user2).add(user1);
            }
            else {
                friendMap.put(user2, new HashSet<>());
                friendMap.get(user2).add(user1);
            }
        }
        return friendMap;
    }
}
