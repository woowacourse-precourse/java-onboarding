package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final Map<String, Integer> scoreMap = new HashMap<>();
    private static final Set<String> friendsOfUserSet = new HashSet<>();
    private static final int SHARE_POINT = 10;
    private static final int VISIT_POINT = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        isUserValid(user, friends, visitors);
        setFriends(friends, user);
        updateScore(friends, visitors);
        removeUnnecessary();

        List<String> answer = theAnswer(scoreMap);
        return answer;
    }

    public static List<String> theAnswer(Map<String, Integer> scoreMap) {
        List<String> sortedList = scoreMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());

        return sortedList;
    }

    public static void isUserValid(String user, List<List<String>> friends, List<String> visitors) {
        String lowerAlphabets = "^[a-z]*$";

        if (user.length() == 0 || user.length() > 30) {
            throw new IllegalArgumentException("user는 길이가 1 이상 30 이하인 문자열이다.");
        }
        if (!user.matches(lowerAlphabets)) {
            throw new IllegalArgumentException("사용자 아이디는 알파벳 소문자로만 이루어져 있다.");
        }

        if (friends.size() == 0 || friends.size() > 10000) {
            throw new IllegalArgumentException("friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.");
        }
        for (List<String> friend : friends) {
            for (String id : friend) {
                if (id.length() == 0 || id.length() > 30) {
                    throw new IllegalArgumentException("아이디는 길이가 1 이상 30 이하인 문자열이다.");
                }
                if (!id.matches(lowerAlphabets)) {
                    throw new IllegalArgumentException("사용자 아이디는 알파벳 소문자로만 이루어져 있다.");
                }
            }
        }

        if (visitors.size() > 10000) {
            throw new IllegalArgumentException("visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.");
        }
        for (String visitor : visitors) {
            if (visitor.length() == 0 || visitor.length() > 30) {
                throw new IllegalArgumentException("아이디는 길이가 1 이상 30 이하인 문자열이다.");
            }
            if (!visitor.matches(lowerAlphabets)) {
                throw new IllegalArgumentException("사용자 아이디는 알파벳 소문자로만 이루어져 있다.");
            }
        }
    }

    public static void removeUnnecessary() {
        for (String friend : friendsOfUserSet) {
            scoreMap.remove(friend);
        }

        for (String name : scoreMap.keySet()) {
            if (scoreMap.get(name) == 0) {
                scoreMap.remove(name);
            }
        }
    }

    public static void updateScore(List<List<String>> friends, List<String> visitors) {
        for (List<String> friend : friends) {
            if (friendsOfUserSet.contains(friend.get(0)) || friendsOfUserSet.contains(friend.get(1))) {
                giveScore(friend.get(0), SHARE_POINT);
                giveScore(friend.get(1), SHARE_POINT);
            }
        }
        for (String visitor : visitors) {
            giveScore(visitor, VISIT_POINT);
        }
    }

    public static void giveScore(String user, int score) {
        scoreMap.put(user, scoreMap.getOrDefault(user, 0) + score);
    }

    public static void setFriends(List<List<String>> friends, String user) {
        for (List<String> friend : friends) {
            if (isFriendOfUser(friend, user)) {
                friendsOfUserSet.addAll(friend);
            }
        }
    }

    public static boolean isFriendOfUser(List<String> friend, String user) {
        return friend.contains(user);
    }
}
