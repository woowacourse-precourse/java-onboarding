package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static final HashSet<String> users = new HashSet<>();
    private static final HashMap<String, List<String>> network = new HashMap<>();
    private static final HashMap<String, Integer> recommendedScore = new HashMap<>();

    public static boolean validCheck(String user, List<List<String>> friends, List<String> visitors) {
        if (user.length() < 1 || user.length() > 30) {
            return false;
        }
        if (friends.size() < 1 || friends.size() > 10000) {
            return false;
        }
        for (List<String> friend : friends) {
            if (friend.size() != 2) {
                return false;
            }
            if (friend.get(0).length() < 1 || friend.get(0).length() > 30) {
                return false;
            }
            if (friend.get(1).length() < 1 || friend.get(1).length() > 30) {
                return false;
            }
        }
        if (visitors.size() > 10000) {
            return false;
        }
        if (friends.stream().distinct().count() != friends.size()) {
            return false;
        }
        return true;
    }

    public static void makeUser(String user, List<List<String>> friends, List<String> visitors) {
        users.add(user);
        for (List<String> friend : friends) {
            users.addAll(friend);
        }
        users.addAll(visitors);
    }

    public static void makeNetwork(List<List<String>> friends) {
        for (String name : users) {
            network.put(name, new ArrayList<>());
        }
        for (List<String> friend : friends) {
            List<String> connectedFirstFriend = network.get(friend.get(0));
            List<String> connectedSecondFriend = network.get(friend.get(1));
            connectedFirstFriend.add(friend.get(1));
            connectedSecondFriend.add(friend.get(0));
            network.put(friend.get(0), connectedFirstFriend);
            network.put(friend.get(1), connectedSecondFriend);
        }
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        if (!validCheck(user, friends, visitors)) {
            throw new IllegalStateException("잘못된 입력입니다.");
        }
        return answer;
    }
}
