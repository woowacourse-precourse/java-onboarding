package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        answer = referralFriends(user,friends,visitors);

        return answer;
    }

    private static List<String> referralFriends(String user, List<List<String>> friends, List<String> visitors){

        List<String> userFriends = getFriendList(user,friends);

        List<String> friendOfFriends = friendOfFriend(user,friends,userFriends);

        List<String> answer = referralFriendsList(userFriends,friendOfFriends,visitors);

        return answer;
    }

    private static List<String> referralFriendsList(List<String> userFriends, List<String> friendOfFriends, List<String> visitors) {


        Map<String,Integer> referrals = new HashMap<>();

        for(String friend : friendOfFriends) {
            referrals.put(friend, (referrals.getOrDefault(friend, 0) + 10));
        }

        for(String friend : visitors) {
            referrals.put(friend, (referrals.getOrDefault(friend, 0) + 1));
        }

        for(String friend : userFriends) {
            if (referrals.containsKey(friend)) {
                referrals.remove(friend);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(referrals.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        List<String> referralList = referrals.keySet().stream().collect(Collectors.toList());

        if(referralList.size() > 5) {
            for(int i = 5 ; i < referralList.size() ; ++i) {
                referralList.remove(i);
            }
        }

        return referralList;
    }

    private static List<String> getFriendList(String user,List<List<String>> friends) {

        List<String> friendList = new ArrayList<>();

        for(List<String> friend : friends) {

            if(!friend.contains(user)){
                continue;
            }

            if(friend.get(0).equals(user)) {
                friendList.add(friend.get(1));
            }

            if(friend.get(1).equals(user)) {
                friendList.add(friend.get(0));
            }
        }

        return friendList;
    }

    private static List<String> friendOfFriend(String user, List<List<String>> friends,  List<String> userFriend) {

        Set<String> friendSet = new HashSet<>();

        for(String friendName : userFriend) {
            for(List<String> friend : friends) {

                if(friend.contains(user))
                    continue;

                if(friend.contains(friendName)) {

                    if(friend.get(0).equals(friendName)) {
                        friendSet.add(friend.get(1));
                    }

                    if(friend.get(1).equals(friendName)) {
                        friendSet.add(friend.get(0));
                    }
                }
            }
        }
        List<String> friendOfFriends = new ArrayList<>(friendSet);

        return friendOfFriends;
    }
}
