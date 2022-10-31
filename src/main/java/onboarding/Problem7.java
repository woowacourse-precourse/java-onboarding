package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashMap<String, Set<String>> friendsMap = friendInit(friends);

        return answer;
    }

    static HashMap<String, Set<String>> friendInit(List<List<String>> friends) {
        HashMap<String, Set<String>> friendsMap = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            String a = friends.get(i).get(0);
            String b = friends.get(i).get(1);

            Set<String> aFriends = friendsMap.getOrDefault(a, new HashSet<>());
            Set<String> bFriends = friendsMap.getOrDefault(b, new HashSet<>());

            aFriends.add(b);
            bFriends.add(a);

            friendsMap.put(a, aFriends);
            friendsMap.put(b, bFriends);
        }

        return friendsMap;
    }
}
