package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, User> userFriendsInfo = makeFriendConnection(friends);
        findScoreOfAcquaintanceAllUser(user, userFriendsInfo);
        addVisitorsScore(visitors, userFriendsInfo);

        return userFriendsInfo.values().stream()
                .filter(eachUser -> eachUser.getScore() != 0)
                .sorted()
                .limit(5)
                .map(eachUser -> eachUser.getUsername())
                .collect(Collectors.toList());
    }

    private static Map<String, User> makeFriendConnection(List<List<String>> friends) {
        Map<String, User> userFriendsInfo = new HashMap<>();
        for (List<String> connect : friends) {
            addConnection(userFriendsInfo, connect);
        }
        return userFriendsInfo;
    }

    private static void addConnection(Map<String, User> userFriendsInfo, List<String> connection) {
        String user1 = connection.get(0);
        String user2 = connection.get(1);

        if (!userFriendsInfo.containsKey(user1)) {
            userFriendsInfo.put(user1, new User(user1));
        }
        userFriendsInfo.get(user1).getFriends().add(user2);

        if (!userFriendsInfo.containsKey(user2)) {
            userFriendsInfo.put(user1, new User(user2));
        }
        userFriendsInfo.get(user2).getFriends().add(user1);
    }

    private static void findScoreOfAcquaintanceAllUser(String user, Map<String, User> userFriendsInfo) {
        userFriendsInfo.keySet().stream()
                .filter(eachUser -> !eachUser.equals(user))
                .forEach(eachUserName -> {
                    int eachScore = findScoreOfAcquaintanceEachUser(user, eachUserName, userFriendsInfo);
                    User eachUser = userFriendsInfo.get(eachUserName);
                    eachUser.addScore(eachScore);
                });
    }

    private static int findScoreOfAcquaintanceEachUser(String user, String each, Map<String, User> userFriendsInfo) {
        Set<String> userFriends = userFriendsInfo.get(user).getFriends();
        Set<String> eachFriends = userFriendsInfo.get(each).getFriends();

        return eachFriends.stream()
                .filter(userFriends::contains)
                .mapToInt(eachFriend -> 10)
                .sum();
    }

    private static void addVisitorsScore(List<String> visitors, Map<String, User> userFriendsInfo) {
        visitors.forEach(visitor -> userFriendsInfo.get(visitor).addScore(1));
    }
}

/* 구현 로직
 * 1. friends 를 탐색하면서 친구 정보를 각 유저의 이름과 Set, 점수가 있는 클래스에 저장한다.
 * 2. 각 유저의 친구 정보를 순환하면서 user의 친구 목록에 들어있는지 확인하고 점수를 추가함
 * 3. visitors 를 순환하면서 점수가 있으면 1을 추가해주고 없으면 새로 만들어서 1로 만들어줌
 * 4. 이름과 점수를 가지고 정렬한 후 5개까지 출력한다.
 * */

/* 기능 목록
 * 1. friends 를 받아서 친구 연결 정보에 대한 HashMap 을 만들어주는 메소드
 *   1-1. 각 유저 연결에 대해서 있는지 없는지 확인하고 추가해주는 메서드
 * 2. 모든 유저의 친구목록을 확인하면서 점수를 갱신해주는 메소드
 *   2-1. 각 유저의 함꼐아는 친구 점수를 찾아서 저장해주는 메소드
 * 3. visitors를 탐색하면서 방문 점수를 추가해주는 메서드
 * */