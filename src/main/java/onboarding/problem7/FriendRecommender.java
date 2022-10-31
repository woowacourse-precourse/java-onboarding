package onboarding.problem7;


import java.util.*;

public class FriendRecommender {
    private final int MAX_RECOMMEND_SIZE = 5;
    private Map<String, Map<String, Boolean>> friendsRelation;
    private Map<String, Integer> friendsScore;

    public List<String> recommend(String user, List<List<String>> friends, List<String> visitors) {
        setFriendsRelation(friends);
        setFriendScore(user);
        setVisitScore(user, visitors);

        List<Map.Entry<String, Integer>> friendsScoreList = new ArrayList<>(friendsScore.entrySet());

        friendsScoreList.sort(new StringIntPair());
        List<String> result = new ArrayList<>();
        int resultSize = 0;
        for (Map.Entry<String, Integer> recommendFriend : friendsScoreList) {
            if (resultSize >= MAX_RECOMMEND_SIZE || recommendFriend.getValue() == 0) {
                break;
            }
            result.add(recommendFriend.getKey());
            resultSize++;
        }

        return result;
    }

    private void setVisitScore(String user, List<String> visitors) {
        Set<String> userFriends = friendsRelation.get(user).keySet();
        for (String visitor : visitors) {
            if (friendsScore.containsKey(visitor)) {
                friendsScore.put(visitor, friendsScore.get(visitor) + 1);
            } else if (!userFriends.contains(visitor) && !visitor.equals(user)) {
                friendsScore.put(visitor, 1);
            }
        }
    }

    private void setFriendScore(String user) {
        friendsScore = new HashMap<>();
        Set<String> userFriends = friendsRelation.get(user).keySet();
        for (String friend : friendsRelation.keySet()) {
            if (friend.equals(user) || userFriends.contains(friend)) {
                continue;
            }
            int friendScore = 0;
            for (String other : friendsRelation.get(friend).keySet()) {
                if (userFriends.contains(other)) {
                    friendScore += 10;
                }
            }
            if (!friendsScore.containsKey(friend)) {
                friendsScore.put(friend, friendScore);
            } else {
                friendsScore.put(friend, friendScore + friendsScore.get(friend));
            }
        }

    }

    private void setFriendsRelation(List<List<String>> friends) {
        friendsRelation = new HashMap<>();
        for (List<String> friendRelation : friends) {
            String friendA = friendRelation.get(0);
            String friendB = friendRelation.get(1);

            boolean isExistA = friendsRelation.containsKey(friendA);
            boolean isExistB = friendsRelation.containsKey(friendB);

            if (!isExistA) {
                friendsRelation.put(friendA, new HashMap<>());
            }
            Map<String, Boolean> aFriends = friendsRelation.get(friendA);
            aFriends.put(friendB, true);

            if (!isExistB) {
                friendsRelation.put(friendB, new HashMap<>());
            }
            Map<String, Boolean> bFriends = friendsRelation.get(friendB);
            bFriends.put(friendA, true);
        }
    }

    private static class StringIntPair implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o1.getValue() - o2.getValue() == 0 ?
                    o1.getKey().compareTo(o2.getKey()) : -(o1.getValue() - o2.getValue());
        }
    }
}
