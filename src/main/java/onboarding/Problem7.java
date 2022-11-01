package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    static final String ERROR = "Error";
    static final int MIN_ID_LENGTH = 1;
    static final int MAX_ID_LENGTH = 30;
    static final int MIN_VISITOR_SIZE = 0;
    static final int MAX_VISITOR_SIZE = 10000;
    static final int MIN_FRIENDS_SIZE = 1;
    static final int MAX_FRIENDS_SIZE = 10000;
    static final int ID_A_INDEX = 0;
    static final int ID_B_INDEX = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        if (!isValidInput(user, friends, visitors)) {
            answer = new ArrayList<>();
            answer.add(ERROR);
            return answer;
        }
        answer = recommendFriends(user, friends, visitors);
        return answer;
    }

    private static List<String> recommendFriends(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Set<String>> friendRelations = new HashMap<>();
        Map<String, Integer> scoreMap = new HashMap<>();
        Map<Integer, List<String>> reverseScoreMap = new HashMap<>();
        Set<String> friendRelation = Collections.emptySet();
        List<String> answer = new LinkedList<>();

        for (List<String> friend : friends) {
            if (!friendRelations.containsKey(friend.get(0))) {
                friendRelation = new HashSet<>();
                friendRelation.add(friend.get(1));
                friendRelations.put(friend.get(0), friendRelation);
            } else if (friendRelations.containsKey(friend.get(0))) {
                friendRelations.get(friend.get(0)).add(friend.get(1));
            }
            if (!friendRelations.containsKey(friend.get(1))) {
                friendRelation = new HashSet<>();
                friendRelation.add(friend.get(0));
                friendRelations.put(friend.get(1), friendRelation);
            } else if (friendRelations.containsKey(friend.get(1))) {
                friendRelations.get(friend.get(1)).add(friend.get(0));
            }
        }

        if (friendRelations.containsKey(user)) {
            for (String userFriend : friendRelations.get(user)) {
                for (String userFriendFriend : friendRelations.get(userFriend)) {
                    if (!friendRelations.get(user).contains(userFriendFriend) && userFriendFriend != user) {
                        if (!scoreMap.containsKey(userFriendFriend)) {
                            scoreMap.put(userFriendFriend, 10);
                        } else if (scoreMap.containsKey(userFriendFriend)) {
                            scoreMap.put(userFriendFriend, scoreMap.get(userFriendFriend) + 10);
                        }
                    }
                }
            }
        }

        for (String visitor : visitors) {
            if (!friendRelations.containsKey(user)) {
                if (!scoreMap.containsKey(visitor)) {
                    scoreMap.put(visitor, 1);
                } else if (scoreMap.containsKey(visitor)) {
                    scoreMap.put(visitor, scoreMap.get(visitor) + 1);
                }
            } else if (!friendRelations.get(user).contains(visitor)) {
                if (!scoreMap.containsKey(visitor)) {
                    scoreMap.put(visitor, 1);
                } else if (scoreMap.containsKey(visitor)) {
                    scoreMap.put(visitor, scoreMap.get(visitor) + 1);
                }
            }
        }

        for (String friend : scoreMap.keySet()) {
            if (!reverseScoreMap.containsKey(scoreMap.get(friend))) {
                List<String> friendList = new ArrayList<>();
                friendList.add(friend);
                reverseScoreMap.put(scoreMap.get(friend), friendList);
            } else if (reverseScoreMap.containsKey(scoreMap.get(friend))) {
                List<String> friendList = reverseScoreMap.get(scoreMap.get(friend));
                friendList.add(friend);
                reverseScoreMap.put(scoreMap.get(friend), friendList);
            }
        }

        List<Integer> keySet = new ArrayList<>(reverseScoreMap.keySet());
        Collections.sort(keySet);
        Collections.reverse(keySet);

        for (Integer key : keySet) {
            List<String> valueSet = new ArrayList<>();
            for (String friend : reverseScoreMap.get(key)) {
                valueSet.add(friend);
            }
            Collections.sort(valueSet);
            for (int i = 0; i < valueSet.size() && answer.size() < 5; i++) {
                answer.add(valueSet.get(i));
            }
        }
        return answer;
    }

    private static boolean isValidInput(String user, List<List<String>> friends, List<String> visitors) {
        if (isValidUserLength(user) && isValidFriendsLength(friends)
            && isValidFriendsIDLength(friends) && isValidVisitorSize(visitors)
            && isValidVisitorIDLength(visitors)) {
            return true;
        }
        return false;
    }

    private static boolean isValidVisitorIDLength(List<String> visitors) {
        for (String visitor : visitors) {
            if (visitor.length() < MIN_ID_LENGTH || visitor.length() > MAX_ID_LENGTH) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidVisitorSize(List<String> visitors) {
        return visitors.size() >= MIN_VISITOR_SIZE && visitors.size() <= MAX_VISITOR_SIZE;
    }

    private static boolean isValidFriendsIDLength(List<List<String>> friends) {
        String IdA;
        String IdB;

        for (List<String> friend : friends) {
            IdA = friend.get(ID_A_INDEX);
            IdB = friend.get(ID_B_INDEX);
            if (IdA.length() < MIN_ID_LENGTH || IdA.length() > MAX_ID_LENGTH) {
                return false;
            }
            if (IdB.length() < MIN_ID_LENGTH || IdB.length() > MAX_ID_LENGTH) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidFriendsLength(List<List<String>> friends) {
        return friends.size() >= MIN_FRIENDS_SIZE && friends.size() <= MAX_FRIENDS_SIZE;
    }

    private static boolean isValidUserLength(String user) {
        return user.length() >= MIN_ID_LENGTH && user.length() <= MAX_ID_LENGTH;
    }
}
