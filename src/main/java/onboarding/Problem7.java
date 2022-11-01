package onboarding;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Problem7 {
    public static Map<String, List<String>> friendsMap;
    public static Map<String, Integer> scoreMap;
    public static int FIRST_FRIEND_INDEX = 0;
    public static int SECOND_FRIEND_INDEX  = 1;
    public static int INIT_SCORE = 0;
    public static int ACQUAINTANCE_SCORE = 10;
    public static int VISITOR_SCORE = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        initScoreMap();
        initFriendsMap(friends);

        plusAcquaintanceScore(user);
        plusVisitorScore(visitors);

        return getTopThreeFriends(user);
    }

    public static void initScoreMap() {
        scoreMap = new HashMap<>();
    }

    public static void initFriendsMap(List<List<String>> friends) {
        friendsMap = new HashMap<>();
        for (List<String> friend : friends) {
            String firstFriend = friend.get(FIRST_FRIEND_INDEX);
            String secondFriend = friend.get(SECOND_FRIEND_INDEX);

            putFriendsMap(firstFriend, secondFriend);
            putFriendsMap(secondFriend, firstFriend);
        }
    }

    public static void putScoreMap(String key, int plusValue) {
        if (!scoreMap.containsKey(key)) {
            scoreMap.put(key, INIT_SCORE);
        }
        scoreMap.put(key, scoreMap.get(key) + plusValue);
    }

    public static void putFriendsMap(String key, String value) {
        if (friendsMap.containsKey(key)) {
            friendsMap.get(key).add(value);
        } else {
            List<String> values = new ArrayList<>();
            values.add(value);
            friendsMap.put(key, values);
        }
    }

    public static void plusAcquaintanceScore(String user) {
        if(!isUserHasFriend(user)){
            return;
        }
        List<String> userFriends = friendsMap.get(user);
        for (String userFriend : userFriends) {
            List<String> acquaintanceList = getAcquaintanceList(user, userFriend);
            acquaintanceList.forEach(ac -> putScoreMap(ac, ACQUAINTANCE_SCORE));
        }
    }

    public static List<String> getAcquaintanceList(String user, String userFriend) {
        return friendsMap.get(userFriend).stream().
                filter(acquaintance -> !acquaintance.equals(user)).collect(Collectors.toList());
    }

    public static void plusVisitorScore(List<String> visitors) {
        visitors.forEach(visitor -> putScoreMap(visitor, VISITOR_SCORE));
    }

    public static List<Entry<String, Integer>> getSortScoreMapEntryList() {
        List<Entry<String, Integer>> entryList = new ArrayList<>(scoreMap.entrySet());
        entryList.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) return o1.getKey().compareTo(o2.getKey());
            return o2.getValue().compareTo(o1.getValue());
        });
        return entryList;
    }

    public static List<String> getTopThreeFriends(String user) {
        List<Entry<String, Integer>> sortScoreMapEntryList = getSortScoreMapEntryList();
        if(isUserHasFriend(user)){
            List<String> userFriendsList = friendsMap.get(user);
            return sortScoreMapEntryList.stream().filter(userScoreEntry -> userScoreEntry.getValue() > 0)
                    .filter(userScoreEntry -> !userFriendsList.contains(userScoreEntry.getKey()))
                    .limit(5).map(Entry::getKey).collect(Collectors.toList());
        }
        return sortScoreMapEntryList.stream().filter(userScoreEntry -> userScoreEntry.getValue() > 0)
                .limit(5).map(Entry::getKey).collect(Collectors.toList());
    }

    public static boolean isUserHasFriend(String user){
        return friendsMap.containsKey(user);
    }

}

