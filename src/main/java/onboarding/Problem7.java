package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, ArrayList<String>> friendsMap = new HashMap<>();
        for(List<String> list : friends) {
            String name1 = list.get(0);
            String name2 = list.get(1);
            if(!friendsMap.containsKey(name1))
                friendsMap.put(name1, new ArrayList<>());

            if(!friendsMap.containsKey(name2))
                friendsMap.put(name2, new ArrayList<>());

            friendsMap.get(name1).add(name2);
            friendsMap.get(name2).add(name1);
        }

        ArrayList<String> userFriendsList = friendsMap.get(user);
        Map<String, Integer> recommendMap = new HashMap<>();
        for(String name : userFriendsList) {

        }
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
