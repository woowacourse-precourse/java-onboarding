package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, List<String>> friendsMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        initFriends(friends);


        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void initFriends(List<List<String>> friends) {

        for (int i = 0; i < friends.size(); i++) {
            List<String> friendShip = friends.get(i);
            String friend1 = friendShip.get(0);
            String friend2 = friendShip.get(1);

            if (friendsMap.get(friend1) == null) {
                friendsMap.put(friend1, new ArrayList<>());
            }

            if (friendsMap.get(friend2) == null) {
                friendsMap.put(friend2, new ArrayList<>());
            }

            friendsMap.get(friend1).add(friend2);
            friendsMap.get(friend2).add(friend1);
        }

    }

}
