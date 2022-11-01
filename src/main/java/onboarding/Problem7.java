package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, ArrayList<String>> friendMap = makeFriendMap(friends);


        return answer;
    }

    public static Map<String, ArrayList<String>> makeFriendMap(List<List<String>> friends) {
        HashMap<String, ArrayList<String>> friendMap = new HashMap<>();

        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);

            ArrayList<String> AFriends = friendMap.getOrDefault(friendA, new ArrayList<>());
            AFriends.add(friendB);
            friendMap.put(friendA, AFriends);

            ArrayList<String> BFriends = friendMap.getOrDefault(friendB, new ArrayList<>());
            BFriends.add(friendA);
            friendMap.put(friendB, BFriends);
        }

        return friendMap;
    }
}
