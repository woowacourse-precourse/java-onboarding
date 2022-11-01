package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * getMyFriends 메서드 선택한 유저의 친구를 set에 저장
 * getAcquaintancePoint 메서드 선택한 유저의 친구와 친구사이면 10점 올림
 * getVisitorsPoint 메서드 값을 해당 유저들의 점수를 1점 올림
 * getAcquaintanceList 메서드 선택한 유저와 이미 친구사이라면 제거, 점수가 0이면 제거
 * getResult 메서드 점수순으로 정렬, 점수가 같으면 이름순으로 정렬, 최대 5까지 반환
 * checkException 메서드 예외를 처리함
 */

public class Problem7 {
    private static Set<String> friendOfUserSet = new HashSet<>();

    private static Map<String, Integer> friendsAndScoreMap = new HashMap<>();

    private static final int ACQUAINTANCE_POINT = 10;

    private static final int VISITORS_POINT = 1;

    private static final int MIN_USER_LENGTH = 1;
    private static final int MAX_USER_LENGTH = 30;
    private static final int MIN_FRIENDS_LENGTH = 1;
    private static final int MAX_FRIENDS_LENGTH = 10000;
    private static final int MIN_ID_LENGTH = 1;
    private static final int MAX_ID_LENGTH = 30;
    private static final int MIN_VISITOR_LENGTH = 0;
    private static final int MAX_VISITOR_LENGTH = 10000;
    private static final String LOWERCASE_ID = "^[a-z]*$";

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        checkUserException(user);
        checkFriendsException(friends);
        checkVisitorException(visitors);
        getMyFriends(friends, user);
        getAcquaintancePoint(friends);
        getVisitorsPoint(visitors);
        getAcquaintanceList();

        return getSortedAcquaintanceList();
    }

    private static List<String> getSortedAcquaintanceList() {
        List<String> answer = friendsAndScoreMap.keySet().stream()
                .sorted((o1, o2) -> {
                    if (friendsAndScoreMap.get(o2).equals(friendsAndScoreMap.get(o1)))
                        return o1.compareTo(o2);
                    return friendsAndScoreMap.get(o2).compareTo(friendsAndScoreMap.get(o1));
                })
                .limit(5)
                .collect(Collectors.toList());
        return answer;
    }


    private static void getAcquaintanceList() {
        for (String friend : friendOfUserSet) {
            friendsAndScoreMap.remove(friend);
        }
        for (String key : friendsAndScoreMap.keySet()) {
            if (friendsAndScoreMap.get(key) == 0) friendsAndScoreMap.remove(key);
        }
    }

    private static void getMyFriends(List<List<String>> friends, String user) {
        for (List<String> friend : friends) {
            if (friend.contains(user)) friendOfUserSet.addAll(friend);
        }
    }

    private static void getAcquaintancePoint(List<List<String>> friends) {
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

    private static void checkUserException(String user) {
        if (user.length() < MIN_USER_LENGTH || user.length() > MAX_USER_LENGTH)
            throw new IllegalArgumentException("user의 길이는 1이상 30이하인 문자열입니다.");
        if (!user.matches(LOWERCASE_ID)) throw new IllegalArgumentException("아이디는 소문자로만 이루어져 있어야합니다.");
    }

    private static void checkFriendsException(List<List<String>> friends) {
        if (friends.size() < MIN_FRIENDS_LENGTH || friends.size() > MAX_FRIENDS_LENGTH)
            throw new IllegalArgumentException("friends는 1이상 10000이하인 리스트/배열입니다.");

        for (List<String> friend : friends) {
            for (String id : friend) {
                if (id.length() < MIN_ID_LENGTH || id.length() > MAX_ID_LENGTH)
                    throw new IllegalArgumentException("아이디는 길이가 1이상 30이하인 문자열입니다.");
                if (!id.matches(LOWERCASE_ID)) throw new IllegalArgumentException("아이디는 소문자로만 이루어져 있어야합니다.");
            }
        }
    }

    private static void checkVisitorException(List<String> visitors) {
        if (visitors.size() < MIN_VISITOR_LENGTH || visitors.size() > MAX_VISITOR_LENGTH)
            throw new IllegalArgumentException("visior는 길이가 0이상 10000이하인 리스트/배열입니다.");

        for (String visitor : visitors) {
            if (visitor.length() < MIN_ID_LENGTH || visitor.length() > MAX_ID_LENGTH)
                throw new IllegalArgumentException("아이디는 길이가 1이상 30이하인 문자열입니다.");
            if (!visitor.matches(LOWERCASE_ID)) throw new IllegalArgumentException("아이디는 소문자로만 이루어져 있어야합니다.");
        }
    }


}