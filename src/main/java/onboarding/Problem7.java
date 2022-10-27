package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static Map<String, List<String>> getFriendsMap(List<List<String>> friends) {
        Map<String, List<String>> friendsMap = new HashMap<>();
        friends.stream()
            .forEach(list -> inputFriendsToMap(friendsMap, list));

        return friendsMap;
    }

    static void inputFriendsToMap(Map<String, List<String>> friendsMap, List<String> friend) {
        String friend1 = friend.get(0);
        String friend2 = friend.get(1);

        inputFriendToMap(friendsMap, friend1, friend2);
        inputFriendToMap(friendsMap, friend2, friend1);
    }

    static void inputFriendToMap(Map<String, List<String>> friendsMap, String friend1, String friend2) {
        List<String> defaultList = new ArrayList<>();
        List<String> friend1Value = friendsMap.getOrDefault(friend1, defaultList);
        friend1Value.add(friend2);
        friendsMap.put(friend1, friend1Value);
    }

    static List<String> getFriendList(List<List<String>> friends, String user) {
        Set<String> friendSet = new HashSet<>();
        List<String> friendList = new ArrayList<>();
        friends.stream()
            .forEach(list -> inputFriendSet(friendSet, list));

        friendList.addAll(friendSet);
        friendList.remove(user);
        return friendList;
    }

    static void inputFriendSet(Set<String> set, List<String> list) {
        set.add(list.get(0));
        set.add(list.get(1));
    }

    static void getTogetherKnowPoint(List<List<String>> friends, String user, Map<String, Integer> scoreMap) {
        Map<String, List<String>> friendsMap = getFriendsMap(friends);
        List<String> friendList = getFriendList(friends,user);
        List<String> userFriends = friendsMap.get(user);

        friendList.stream()
            .forEach(f -> inputScore(friendsMap, userFriends, scoreMap, f));
    }

    static void inputScore(Map<String, List<String>> friendsMap, List<String> userFriends, Map<String, Integer> scoreMap, String friend) {
        int count = (int) friendsMap.get(friend).stream()
            .filter(x -> userFriends.contains(x))
            .count();

        scoreMap.put(friend, count * 10);
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

        Map<String, List<String>> friendsMap = getFriendsMap(friends);
        List<String> friendList = getFriendList(friends,user);
        getTogetherKnowPoint(friends, user);
    }

}
