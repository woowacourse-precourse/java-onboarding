package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String, HashSet<String>> friendsMap = new HashMap<String, HashSet<String>>();

        for (int i = 0; i < friends.size(); i++) {
            List<String> relation = friends.get(i);

            String member1 = relation.get(0);
            String member2 = relation.get(1);

            makeFriendsMap(friendsMap, member1, member2);
            makeFriendsMap(friendsMap, member2, member1);
        }

        return answer;
    }

    private static void makeFriendsMap(HashMap<String, HashSet<String>> friendsMap, String member1, String member2) {
        if (friendsMap.containsKey(member1)) {
            HashSet<String> set = friendsMap.get(member1);
            set.add(member2);
            friendsMap.put(member1, set);
        } else {
            HashSet<String> set = new HashSet<>();
            set.add(member2);
            friendsMap.put(member1, set);
        }
    }
}
