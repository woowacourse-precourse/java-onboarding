package onboarding;

import java.util.*;

public class Problem7 {
    public static boolean isContainUser(String user, List<String> friend) {
        if(friend.contains(user)) {
            return true;
        }
        return false;
    }

    public static String getFriendName(String user, List<String> friend) {
        if(user.equals(friend.get(0))) {
            return friend.get(1);
        }
        else {
            return friend.get(0);
        }
    }

    public static Set<String> getFriendSet(String user, List<List<String>> friends){
        Set<String> friendSet = new HashSet<>();

        for(List<String> friend: friends) {
            if(isContainUser(user, friend)) {  // user가 있는 친구 목록일 경우
                String friendName = getFriendName(user, friend);
                friendSet.add(friendName);
            }
        }

        return friendSet;
    }

    public static boolean isSameFriend(String user, String userFriend, List<String> friend) {
        if(isContainUser(user, friend)) {   // user가 있다면 체크 X
            return false;
        }

        if(!isContainUser(userFriend, friend)) {    // user의 친구가 없다면 false
            return false;
        }

        return true;
    }

    public static String getSameFriendName(String user, Set<String> friendSet, List<String> friend) {
        for(String userFriend : friendSet) {
            if(isSameFriend(user, userFriend, friend)) {
                return getFriendName(userFriend, friend);
            }
        }

        return null;
    }

    public static Map<String, Integer> getFriendsScore(String user, Set<String> friendSet, List<List<String>> friends) {
        Map<String, Integer> scoreMap = new HashMap<>();

        for(List<String> friend : friends) {
            String friendName = getSameFriendName(user, friendSet, friend);

            if(friendName == null) {
                continue;
            }

            if(!scoreMap.containsKey(friendName)) {
                scoreMap.put(friendName, 0);
            }
            scoreMap.put(friendName, scoreMap.get(friendName) + 10);
        }

        return scoreMap;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Set<String> friendSet;
        Map<String, Integer> friendsScore;

        friendSet = getFriendSet(user, friends);
        friendsScore = getFriendsScore(user, friendSet, friends);

        return answer;
    }
}
