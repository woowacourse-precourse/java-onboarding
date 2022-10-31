package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private final static HashMap<String, Integer> map = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        validateUserNameLength(user);
        validateFriendsSize(friends);
        validateVisitorSize(visitors);

        List<String> bf = findBestFriends(user, friends);
        System.out.println(bf);

        putVisitor(map, visitors);
        putFriends(map, friends);

        map.remove(user);
        removeElementsFromMap(map, bf);

        countVisitPoint(map, visitors);
        countNotFriendPoint(map, friends);

        return getAnswer(map);
    }

    private static List<String> getAnswer(Map<String, Integer> map) {

        int cnt = 0;
        for (String name : map.keySet()) {
            if (map.get(name) == 0) {
                cnt++;
            }
        }

        if (cnt == map.size()) {
            return Collections.emptyList();
        }
        else {
            return map.keySet().stream().collect(Collectors.toList());
        }
    }

    private static void countNotFriendPoint(Map<String, Integer> map, List<List<String>> friends) {
        for (List<String> friend : friends) {
            for (String name : friend) {
                if (map.containsKey(name)) {
                    map.put(name, map.get(name)+10);
                }
            }
        }
    }

    private static void countVisitPoint(Map<String, Integer> map, List<String> visitors) {
        for (String name : visitors) {
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            }
        }
    }

    private static void putFriends(Map<String, Integer> map, List<List<String>> friends) {
        for (List<String> friend : friends) {
            for (String name : friend) {
                map.put(name, 0);
            }
        }
    }

    private static void putVisitor(Map<String, Integer> map, List<String> visitors) {
        for (String visitor : visitors) {
            map.put(visitor, 0);
        }
    }

    private static void removeElementsFromMap(Map<String, Integer> list, List<String> elements) {
        for (String ele : elements) {
            list.remove(ele);
        }
    }

    private static List<String> findBestFriends(String user, List<List<String>> friends) {

        List<String> bestFriend = new ArrayList<>();

        for (List<String> friend: friends) {
            if (friend.contains(user)) {

                for (String name : friend) {
                    if (!name.equals(user)) {

                        bestFriend.add(name);
                    }
                }
            }
        }

        return bestFriend;
    }

    private static void validateUserNameLength(String user) {
        int length = user.length();
        boolean isCorrectNameLength = 1 <= length && length <= 30;

        if (!isCorrectNameLength) {
            throw new IllegalArgumentException("유저 이름 크기는 1 이상 30이하 여야 합니다.");
        }
    }

    private static void validateFriendsSize(List<List<String>> friends) {
        int size = friends.size();
        boolean isCorrectListSize = 1 <= size && size <= 10_000;

        if (!isCorrectListSize) {
            throw new IllegalArgumentException("friends는 길이가 1 이상 10,000 이하 이어야 합니다.");
        }

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).size() != 2) {
                throw new IllegalArgumentException("friends의 각 원소는 길이가 2 이어야 한다.");
            }
        }
    }

    private static void validateVisitorSize(List<String> list) {
        int size = list.size();
        boolean isCorrectListSize = 1 <= size && size <= 10_000;

        if (!isCorrectListSize) {
            throw new IllegalArgumentException("길이가 1 이상 10,000 이하 여야 합니다.");
        }
    }
}
