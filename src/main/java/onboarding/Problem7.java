package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int FRIEND_OF_FRIEND_SCORE = 10;
    private static final int VISIT_SCORE = 1;
    private static HashMap<String, Integer> newFriendScore = new HashMap<>();
    private static HashSet<String> myFriends = new HashSet<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        myFriends.clear();
        newFriendScore.clear();

        findMyFriends(user, friends);
        findRelatedFriends(user, friends);
        findVisitors(user, visitors);

        List<String> answer = getRecommendation();
        return answer;
    }

    private static void findMyFriends(String user, List<List<String>> friends) {
        for (List<String> friendInfo : friends) {
            String myFriend = checkMyFriendName(user, friendInfo);
            updateMyFriends(myFriend);
        }
    }

    private static void findRelatedFriends(String user, List<List<String>> friends) {
        //시간 성능을 고려하여 Stream API 가 아닌 전통 for 문 사용
        for (List<String> friendInfo : friends) {
            String friendOfFriend = checkFriendOfFriend(friendInfo);
            updateNewFriendScore(user, friendOfFriend, FRIEND_OF_FRIEND_SCORE);
        }
    }

    private static void findVisitors(String user, List<String> visitors) {
        for (String visitor : visitors) {
            updateNewFriendScore(user, visitor, VISIT_SCORE);
        }
    }

    private static List<String> getRecommendation() {
        List<Map.Entry<String, Integer>> newFriendsList = new LinkedList<>(newFriendScore.entrySet());
        newFriendsList = sortByScoreAndName(newFriendsList);
        List<String> answer = newFriendsList.stream()
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());

        return answer;

    }

    private static String checkMyFriendName(String user, List<String> friendInfo) {
        String userA = friendInfo.get(0);
        String userB = friendInfo.get(1);
        if(userA.equals(user)) {
            return userB;
        }
        if(userB.equals(user)) {
            return userA;
        }
        return null;
    }

    private static void updateMyFriends(String friend) {
        if(friend == null) {
            return;
        }
        myFriends.add(friend);
    }

    private static void updateNewFriendScore(String user, String newFriend, int scoreType) {
        if(newFriend == null) {
            return;
        }
        if(isMe(newFriend, user)) {
            return;
        }
        if(isAlreadyMyFriend(newFriend)) {
            return;
        }
        int score = scoreType;
        if(newFriendScore.containsKey(newFriend)) {
            score += newFriendScore.get(newFriend);
            newFriendScore.put(newFriend, score);
            return;
        }
        newFriendScore.put(newFriend, score);
    }

    private static String checkFriendOfFriend(List<String> friendInfo) {
        String userA = friendInfo.get(0);
        String userB = friendInfo.get(1);
        if(myFriends.contains(userA)) {
            return userB;
        }
        if(myFriends.contains(userB)) {
            return userA;
        }
        return null;
    }

    private static Boolean isAlreadyMyFriend(String friend) {
        if(myFriends.contains(friend)) {
            return true;
        }
        return false;
    }

    private static Boolean isMe(String friend, String user) {
        if(friend.equals(user)) {
            return true;
        }
        return false;
    }

    private static List<Map.Entry<String, Integer>> sortByScoreAndName(List<Map.Entry<String, Integer>> newFriendsList) {
        newFriendsList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o2.getValue().equals(o1.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return newFriendsList;
    }

}
