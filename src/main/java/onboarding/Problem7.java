package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> sort(HashMap<String, Integer> sharedFriends) {
        List<String> keySet = new ArrayList<>(sharedFriends.keySet());
        keySet.sort((o1, o2) -> sharedFriends.get(o2).compareTo(sharedFriends.get(o1)));
        System.out.println("keySet" + keySet);
        return keySet;
    }

    public static HashMap<String, Integer> checkVisitors(List<String> visitors, HashMap<String, Integer> sharedFrineds, HashSet<String> userFriends) {
        for(String visitor : visitors) {
            if(userFriends.contains(visitor)) {
                continue;
            }
            if(sharedFrineds.containsKey(visitor)) {
                sharedFrineds.replace(visitor, sharedFrineds.get(visitor), sharedFrineds.get(visitor) + 1);
            } else {
                sharedFrineds.put(visitor, 1);
            }
        }
        System.out.println(sharedFrineds);
        return sharedFrineds;
    }

    public static HashMap<String, Integer> createSharedFriendsHashmap(List<List<String>> friends, HashSet<String> userFriends, String user) {
        HashMap<String, Integer> sharedFriends = new HashMap<String, Integer>();
        for(String userFriend : userFriends) {
            for(List<String> friend : friends) {
                if(friend.get(0) == user || friend.get(1) == user) {
                    continue;
                } else{
                    String key = null;
                    if(friend.get(0) == userFriend){
                        key = friend.get(1);
                        if(sharedFriends.containsKey(key)) {
                            sharedFriends.replace(key, sharedFriends.get(key), sharedFriends.get(key) + 10);
                        } else {
                            sharedFriends.put(key, 10);
                        }
                    } else if(friend.get(1) == userFriend) {
                        key = friend.get(0);
                        if(sharedFriends.containsKey(key)) {
                            sharedFriends.replace(key, sharedFriends.get(key), sharedFriends.get(key) + 10);
                        } else {
                            sharedFriends.put(key, 10);
                        }
                    }
                }
            }
        }
        return sharedFriends;
    }

    public static HashSet<String> findUserFriends(String user, List<List<String>> friends) {
        HashSet<String> userFriend = new HashSet<String>();
        for(List<String> friend :  friends) {
            if(friend.get(0) == user) {
                userFriend.add(friend.get(1));
            } else if(friend.get(1) == user) {
                userFriend.add(friend.get(0));
            }
        }
        return userFriend;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashSet<String> userFriends = findUserFriends(user, friends);
        HashMap<String, Integer> sharedFriendsMap = createSharedFriendsHashmap(friends, userFriends, user);
        checkVisitors(visitors, sharedFriendsMap, userFriends);
        answer = sort(sharedFriendsMap);
        return answer;
    }

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        solution(user, friends, visitors);
    }
}
