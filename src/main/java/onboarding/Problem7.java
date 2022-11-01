package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, Integer> getNewFriendMap(List<String> alreadyFriend, List<List<String>> candidate, List<String> visitors) {
        Map<String, Integer> newFriend = new HashMap<>();
        calWithAlreadyFriend(alreadyFriend, candidate, newFriend);
        calWithVisitors(visitors, alreadyFriend, newFriend);
        return newFriend;
    }

    private static void calWithAlreadyFriend(List<String> alreadyFriend, List<List<String>> exceptUserList, Map<String, Integer> newFriend) {
        for (List<String> friend : exceptUserList) {
            if (isAlreadyFriend(friend.get(0), alreadyFriend) && !isAlreadyFriend(friend.get(1), alreadyFriend)) {
                calculate(newFriend, friend.get(1), 10);
            }
            if (!isAlreadyFriend(friend.get(0), alreadyFriend) && isAlreadyFriend(friend.get(1), alreadyFriend)) {
                calculate(newFriend, friend.get(0), 10);
            }
            if (!isAlreadyFriend(friend.get(0), alreadyFriend) && !isAlreadyFriend(friend.get(1), alreadyFriend)) {
                calculate(newFriend, friend.get(1), 10);
                calculate(newFriend, friend.get(0), 10);
            }
        }
    }

    private static void calWithVisitors(List<String> visitors, List<String> alreadyFriend, Map<String, Integer> newFriend) {
        for (String visitor : visitors) {
            if (isAlreadyFriend(visitor, alreadyFriend))
                continue;
            calculate(newFriend, visitor, 1);
        }
    }

    private static boolean isAlreadyFriend(String s, List<String> alreadyFriend) {
        if (alreadyFriend.contains(s))
            return true;
        return false;
    }

    private static void calculate(Map<String, Integer> newFriend, String friend, int score) {
        if (newFriend.containsKey(friend)) {
            newFriend.replace(friend, newFriend.get(friend) + score);
        } else {
            newFriend.put(friend, score);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> alreadyFriend = new ArrayList<>();
        List<List<String>> candidate = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.get(0) == user) {
                alreadyFriend.add(friend.get(1));
            } else if (friend.get(1) == user) {
                alreadyFriend.add(friend.get(0));
            } else {
                candidate.add(friend);
            }
        }

        Map<String, Integer> newFriend = getNewFriendMap(alreadyFriend, candidate, visitors);
        List<String> answer = suggestion(newFriend);
        return answer;
    }
}
