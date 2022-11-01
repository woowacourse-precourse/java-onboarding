package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> friendsOfUser = new ArrayList<>();
        Map<String, Integer> scoreMap = new HashMap<>();

        findFriendsOfUser(user, friends, friendsOfUser);

        addAcquaintanceInMap(user, friends, friendsOfUser, scoreMap);

        addVisitor(visitors, friendsOfUser, scoreMap);

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scoreMap.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        int minSize = Math.min(4,entryList.size()-1);
        for (int i = 0; i <= minSize; i++) {
            answer.add(entryList.get(i).getKey());
        }

        return answer;
    }

    private static void addVisitor(List<String> visitors, List<String> friendsOfUser, Map<String, Integer> scoreMap) {
        for (String visitor: visitors) {
            if (!friendsOfUser.contains(visitor)) {
                if (!scoreMap.containsKey(visitor)) {
                    scoreMap.put(visitor, 1);
                } else {
                    int score = scoreMap.get(visitor) + 1;
                    scoreMap.put(visitor, score);
                }
            }
        }
    }

    private static void addAcquaintanceInMap(String user, List<List<String>> friends, List<String> friendsOfUser, Map<String, Integer> scoreMap) {
        for (List<String> friend : friends) {
            for (String friendOfUser : friendsOfUser) {
                if (friend.contains(friendOfUser) && !friend.contains(user)) {
                    for (int i = 0; i < friend.size(); i++) {
                        if (!friend.get(i).equals(friendOfUser)) {
                            if (!scoreMap.containsKey(friend.get(i))) {
                                scoreMap.put(friend.get(i), 10);
                            } else {
                                int score = scoreMap.get(friend.get(i)) + 10;
                                scoreMap.put(friend.get(i), score);
                            }
                        }
                    }

                }
            }
        }
    }

    private static void findFriendsOfUser(String user, List<List<String>> friends, List<String> friendsOfUser) {
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                for (String friend : friends.get(i)) {
                    if (!friend.equals(user)) {
                        friendsOfUser.add(friend);
                    }
                }
            }
        }
    }
}
