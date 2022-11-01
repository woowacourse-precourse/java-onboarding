package onboarding;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Problem7 {
    public static Map<String, List<String>> userFriendsListMap;
    public static Map<String, Integer> userScoreMap;
    public static int FIRST_FRIEND_INDEX = 0;
    public static int SECOND_FRIEND_INDEX  = 1;
    public static int INIT_SCORE = 0;
    public static int ACQUAINTANCE_SCORE = 10;
    public static int VISITOR_SCORE = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        initUserScoreMap();
        initUserFriendsListMap(friends);

        plusAcquaintanceScore(user);
        plusVisitorScore(visitors);

        return getTopFiveScoreFriends(user);
    }

    public static void initUserScoreMap() {
        userScoreMap = new HashMap<>();
    }

    public static void initUserFriendsListMap(List<List<String>> friends) {
        userFriendsListMap = new HashMap<>();
        for (List<String> friend : friends) {
            String firstFriend = friend.get(FIRST_FRIEND_INDEX);
            String secondFriend = friend.get(SECOND_FRIEND_INDEX);

            putUserFriendsMap(firstFriend, secondFriend);
            putUserFriendsMap(secondFriend, firstFriend);
        }
    }

    public static void plusUserScore(String key, int plusValue) {
        if (!userScoreMap.containsKey(key)) {
            userScoreMap.put(key, INIT_SCORE);
        }
        userScoreMap.put(key, userScoreMap.get(key) + plusValue);
    }

    public static void putUserFriendsMap(String key, String value) {
        if (userFriendsListMap.containsKey(key)) {
            userFriendsListMap.get(key).add(value);
        } else {
            List<String> values = new ArrayList<>();
            values.add(value);
            userFriendsListMap.put(key, values);
        }
    }

    public static void plusAcquaintanceScore(String user) {
        if(!isUserHasFriends(user)){
            return;
        }
        List<String> userFriends = userFriendsListMap.get(user);
        for (String userFriend : userFriends) {
            List<String> acquaintanceList = getAcquaintanceList(user, userFriend);
            acquaintanceList.forEach(ac -> plusUserScore(ac, ACQUAINTANCE_SCORE));
        }
    }

    public static List<String> getAcquaintanceList(String user, String userFriend) {
        return userFriendsListMap.get(userFriend).stream().
                filter(acquaintance -> !acquaintance.equals(user)).collect(Collectors.toList());
    }

    public static void plusVisitorScore(List<String> visitors) {
        visitors.forEach(visitor -> plusUserScore(visitor, VISITOR_SCORE));
    }

    public static List<Entry<String, Integer>> getSortedScoreMapEntryList() {
        List<Entry<String, Integer>> entryList = new ArrayList<>(userScoreMap.entrySet());
        entryList.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) return o1.getKey().compareTo(o2.getKey());
            return o2.getValue().compareTo(o1.getValue());
        });
        return entryList;
    }

    public static List<String> getTopFiveScoreFriends(String user) {
        List<Entry<String, Integer>> sortScoreMapEntryList = getSortedScoreMapEntryList();
        if(isUserHasFriends(user)){
            List<String> userFriendsList = userFriendsListMap.get(user);
            return sortScoreMapEntryList.stream().filter(userScoreEntry -> userScoreEntry.getValue() > 0)
                    .filter(userScoreEntry -> !userFriendsList.contains(userScoreEntry.getKey()))
                    .limit(5).map(Entry::getKey).collect(Collectors.toList());
        }
        return sortScoreMapEntryList.stream().filter(userScoreEntry -> userScoreEntry.getValue() > 0)
                .limit(5).map(Entry::getKey).collect(Collectors.toList());
    }

    public static boolean isUserHasFriends(String user){
        return userFriendsListMap.containsKey(user);
    }

}

