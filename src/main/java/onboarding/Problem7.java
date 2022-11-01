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

    private static void setScoreToFriendOfUserFriend(List<String> friendsOfUserFriends) {

        for(String friend: friendsOfUserFriends)
            recommends.putIfAbsent(friend, 10);
    }

    private static void getFriendsScore(String user, List<List<String>> friends) {
        List<String> userFriends = getfriendListOfUser(user, friends);

        for(String friend : userFriends) {
            List<String> friendsOfUserFriends = getfriendListOfUser(friend, friends);
            friendsOfUserFriends.remove(user);
            friendsOfUserFriends.removeAll(userFriends);

            setScoreToFriendOfUserFriend(friendsOfUserFriends);

        }
    }
    private static void getVisitorsScore(List<String> userFriends, List<String> visitors) {

        for(String visitor : visitors) {
            if(recommends.containsKey(visitor)) {
                recommends.put(visitor, recommends.get(visitor) + 1);

            } else if(!userFriends.contains(visitor)){
                recommends.put(visitor, 1);
            }
        }
    }

    public static int compareByScoreAndName(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        int comparison = (o1.getValue() - o2.getValue()) * -1;
        return comparison == 0 ? o1.getKey().compareTo(o2.getKey()) : comparison;
    }

    private static List<Map.Entry<String, Integer>> sort(HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        entries.sort(Problem7::compareByScoreAndName);

        return entries;
    }

    private static List<String> convertEntriesToList(List<Map.Entry<String, Integer>> entries) {
        List<String> result = new ArrayList<>(Collections.emptyList());

        for(Map.Entry<String, Integer> entry: entries)
            result.add(entry.getKey());

        return result;

    }


}
