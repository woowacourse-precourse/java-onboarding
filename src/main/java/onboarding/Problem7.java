package onboarding;

import java.util.*;

/**
 * getMyFriends 메서드 선택한 유저의 친구를 set에 저장
 * getAcquaintancePoint 메서드 선택한 유저의 친구와 친구사이면 10점 올림
 * getVisitorsPoint 메서드 값을 해당 유저들의 점수를 1점 올림
 * getAcquaintanceList 메서드 선택한 유저와 이미 친구사이라면 제거, 점수가 0이면 제거
 * getResult 메서드 점수순으로 정렬, 점수가 같으면 이름순으로 정렬, 최대 5까지 반환
 */

public class Problem7 {
    private static Set<String> friendOfUserSet = new HashSet();

    private static Map<String, Integer> friendsAndScoreMap = new HashMap<>();

    private static final int ACQUAINTANCE_POINT = 10;

    private static final int VISITORS_POINT = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void getMyFriends(List<List<String>> friends, String user) {
        for (List<String> friend : friends) {
            if (friend.contains(user)) friendOfUserSet.addAll(friend);
        }
    }

    private static void getAcquaintancePoint(List<List<String>> friends, String user) {
        for (List<String> friend : friends) {
            String firstFriend = friend.get(0);
            String secondFriend = friend.get(1);
            if (friendOfUserSet.contains(firstFriend) || friendOfUserSet.contains(secondFriend)) {
                friendsAndScoreMap.put(firstFriend, friendsAndScoreMap.getOrDefault(firstFriend, 0) + ACQUAINTANCE_POINT);
                friendsAndScoreMap.put(secondFriend, friendsAndScoreMap.getOrDefault(secondFriend, 0) + ACQUAINTANCE_POINT);
            }
        }
    }
    private static void getVisitorsPoint(List<String> friends) {
        for (String friend : friends) {
            friendsAndScoreMap.put(friend, friendsAndScoreMap.getOrDefault(friend, 0) + VISITORS_POINT);
        }
    }

}