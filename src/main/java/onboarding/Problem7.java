package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, HashSet<String>> friendMap = arrangeFriends(friends);


        return answer;
    }

    public static HashMap<String, HashSet<String>> arrangeFriends(List<List<String>> friends) {
        HashMap<String, HashSet<String>> friendMap = new HashMap<>();

        for(List<String> friend : friends) {
            HashSet<String> friendsSet;

            if (friendMap.containsKey(friend.get(0))) {
                friendsSet = friendMap.get(friend.get(0));
            }else{
                friendsSet = new HashSet<>();
            }

            friendsSet.add(friend.get(1));
            friendMap.put(friend.get(0), friendsSet);

            if (friendMap.containsKey(friend.get(1))) {
                friendsSet = friendMap.get(friend.get(1));
            }else{
                friendsSet = new HashSet<>();
            }

            friendsSet.add(friend.get(0));
            friendMap.put(friend.get(1), friendsSet);
        }

        return friendMap;
    }
}
