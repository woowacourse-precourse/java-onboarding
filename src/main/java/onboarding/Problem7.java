package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static final int DEFAULT_SCORE = 0;
    public static final int FRIEND_TOGETHER_SCORE = 10;
    public static final int FRIEND_VISITED_SCORE = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, Integer> scoreBoard = new HashMap<>();
        Set<String> friendList = new HashSet<>();

        // 친구목록 찾아오기(초기화)
        initializeFriendList(user, friendList, friends);

        // 친구의 친구 목록 확인하고 점수 주기
        giveFriendOfFriendScore(user, friendList, friends, scoreBoard);

        // 방문자들 점수주기
        giveVisitorsScore(visitors, scoreBoard);

        // scoreBoard에서 user의 친구가 아니며 점수가 0점 이상인 사람만 5명 추리기
        answer = getTop5RecommendedFriendList(friendList, scoreBoard);

        return answer;
    }

    public static void initializeFriendList(String user, Set<String> friendList, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                if (friend.get(0).equals(user)) {
                    friendList.add(friend.get(1));
                } else {
                    friendList.add(friend.get(0));
                }
            }
        }
    }

    public static void giveFriendOfFriendScore(String user, Set<String> friendList, List<List<String>> friends, Map<String, Integer> scoreBoard) {
        friendList.forEach(friendID -> friends.forEach(friendBetweenList -> {
            if (friendBetweenList.contains(friendID) && !friendBetweenList.contains(user)) {
                if (friendBetweenList.get(0).equals(friendID)) {
                    scoreBoard.put(friendBetweenList.get(1), scoreBoard.getOrDefault(friendBetweenList.get(1), DEFAULT_SCORE) + FRIEND_TOGETHER_SCORE);
                } else {
                    scoreBoard.put(friendBetweenList.get(0), scoreBoard.getOrDefault(friendBetweenList.get(0), DEFAULT_SCORE) + FRIEND_TOGETHER_SCORE);
                }
            }
        }));
    }

    public static void giveVisitorsScore(List<String> visitors, Map<String, Integer> scoreBoard) {
        visitors.forEach(visitor -> scoreBoard.put(visitor, scoreBoard.getOrDefault(visitor, DEFAULT_SCORE) + FRIEND_VISITED_SCORE));
    }

    public static List<String> getTop5RecommendedFriendList(Set<String> friendList, Map<String, Integer> scoreBoard) {
        return scoreBoard.entrySet().stream()
                .filter(eachEntry -> eachEntry.getValue() > 0 && !friendList.contains(eachEntry.getKey()))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
