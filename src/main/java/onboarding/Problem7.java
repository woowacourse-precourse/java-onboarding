package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static HashMap<String, Integer> recommends = new HashMap<>();

    private static String findFriendInPairs(String user, List<String> pairs) {

        return pairs.get(0).equals(user) ?
               pairs.get(1) :
               pairs.get(0);
    }

    private static List<String> getfriendListOfUser(String user, List<List<String>> friends) {
        ArrayList<String> friendList = new ArrayList<>();

        for(List<String> pairs : friends) {
            if(pairs.contains(user)) {
                String addFriend = findFriendInPairs(user, pairs);
                friendList.add(addFriend);
            }
        }

        return friendList;
    }

}
