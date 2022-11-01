package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/*
기능 구현 사항
1. user는 1이상 30이하의 문자열
2. A, B의 친구 리스트에 각각 B, A 추가
3. visitors에 존재하는 친구 1점 추가
4. 나와 같은 친구를 아는 사람 10점 추가
5. 추천 점수가 0점이면 추첨 X, 추첨 점수 같으면 이름순 정렬
6. 점수가 같은 순 정렬, 최대 5명 return
 */

public class Problem7 {
    private static final Map<String, ArrayList<String>> friendRelation = new HashMap<>();
    private static final Map<String, Integer> friendScore = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        createFriendRelation(friends);
        calculateSameFriendScore(user);
        calculateVisitorScore(visitors);

        ArrayList<String> userFriends = friendRelation.get(user);
        for(String userFriend: userFriends) {
            friendScore.remove(userFriend);
        }

        return convertMapToList();
    }

    private static void createFriendRelation(List<List<String>> friends) {
        for(List<String> friendList: friends) {
            String firstFriend = friendList.get(0);
            String secondFriend = friendList.get(1);
            connectFriendRelation(firstFriend, secondFriend);
        }
    }

    private static void connectFriendRelation(String firstFriend, String secondFriend) {
        if(!friendScore.containsKey(firstFriend)) {
            friendScore.put(firstFriend, 0);
        }
        if(!friendScore.containsKey(secondFriend)) {
            friendScore.put(secondFriend, 0);
        }
        if(!friendRelation.containsKey(firstFriend)) {
            friendRelation.put(firstFriend, new ArrayList<>());
        }
        if(!friendRelation.containsKey(secondFriend)) {
            friendRelation.put(secondFriend, new ArrayList<>());
        }
        friendRelation.get(firstFriend).add(secondFriend);
        friendRelation.get(secondFriend).add(firstFriend);
    }

    private static void calculateSameFriendScore(String user) {
        for(String friend: friendRelation.keySet()) {
            if (friend.equals(user)) {
                continue;
            }
            ArrayList<String> sameFriendList = findSameFriend(user, friend);
            Integer previousScore = friendScore.get(friend);
            friendScore.put(friend, previousScore+(10 * sameFriendList.size()));
        }
    }

    private static void calculateVisitorScore(List<String> visitors) {
        for(String visitor: visitors) {
            if(!friendScore.containsKey(visitor)) {
                friendScore.put(visitor, 0);
            }
            Integer previousScore = friendScore.get(visitor);
            friendScore.put(visitor, previousScore+1);
        }
    }

    private static ArrayList<String> findSameFriend(String user, String otherUser) {
        ArrayList<String> sameFriends = new ArrayList<>(friendRelation.get(user));
        ArrayList<String> otherUserFriends = friendRelation.get(otherUser);
        sameFriends.retainAll(otherUserFriends);
        return sameFriends;
    }

    private static List<String> convertMapToList() {
        List<String> scoreResult = friendScore.entrySet()
                .stream()
                .filter(e-> e.getValue() != 0)
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
        return scoreResult;
    }
}
