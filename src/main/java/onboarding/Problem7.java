package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> usersFriendsList = new HashMap<String, List<String>>();
        Map<String, Integer> userScore = new LinkedHashMap<String, Integer>();
        for (List<String> friendRelationship : friends) {
            String firstFriendInRelation = friendRelationship.get(0);
            String secondFriendInRelation = friendRelationship.get(1);
            if (!userScore.containsKey(firstFriendInRelation) && !user.equals(firstFriendInRelation)) {
                userScore.put(firstFriendInRelation, 0);
            }
            if (!userScore.containsKey(secondFriendInRelation) && !user.equals(secondFriendInRelation)) {
                userScore.put(secondFriendInRelation, 0);
            }
            if (!usersFriendsList.containsKey(firstFriendInRelation)) {
                usersFriendsList.put(firstFriendInRelation, new ArrayList<String>());
            }
            if (!usersFriendsList.containsKey(secondFriendInRelation)) {
                usersFriendsList.put(secondFriendInRelation, new ArrayList<String>());
            }
            usersFriendsList.get(firstFriendInRelation).add(secondFriendInRelation);
            usersFriendsList.get(secondFriendInRelation).add(firstFriendInRelation);
        }

        List<String> userFriend = usersFriendsList.get(user);
        for (String friend : usersFriendsList.keySet()) {
            if (!friend.equals(user) && !userFriend.contains(friend)) {
                List<String> friendsList = usersFriendsList.get(friend);
                for (String item : friendsList) {
                    if ((usersFriendsList.get(user)).contains(item)) {
                        int score = userScore.get(friend);
                        userScore.put(friend, score + 10);
                    }
                }
            }
        }
        for (String visitor : visitors) {
            if (!userScore.containsKey(visitor) && !userFriend.contains(visitor)) {
                userScore.put(visitor, 1);
            } else {
                if (!userFriend.contains(visitor)) {
                    int score = userScore.get(visitor);
                    userScore.put(visitor, score + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> scoreBoard = new LinkedList<>(userScore.entrySet());
        Collections.sort(scoreBoard, (a, b) -> {
            if (a.getValue() == b.getValue()) {
                return a.getKey().compareTo(b.getKey());
            } else {
                return b.getValue().compareTo(a.getValue());
            }
        });
        List<String> result = new ArrayList<String>();
        for (Map.Entry<String, Integer> friendScore : scoreBoard) {
            if (friendScore.getValue() != 0 && result.size() < 5) {
                result.add(friendScore.getKey());
            }
        }

        return result;
    }
}
