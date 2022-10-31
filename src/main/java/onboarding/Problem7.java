package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 기능 목록
 * 1. 사용자와 함께 아는 친구의 수로 점수 계산
 * 2. 사용자의 타임 라인에 방문한 횟수로 점수 계산
 * 3. 총 점수 계산
 * 4. 3번을 이용해 최대 5명 목록 구하기
 */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scoresOfUsers = new HashMap<>();
        HashMap<String, ArrayList<String>> friendsOfUsers = new HashMap<>();

        for (List<String> relationship : friends) {
            initializeScores(scoresOfUsers, relationship);
            getFriendsOfUser(friendsOfUsers, relationship);
        }

        final ArrayList<String> friendsOfUser = friendsOfUsers.get(user);
        for (String friendUser : scoresOfUsers.keySet()) {
            scoresOfUsers.put(friendUser, CalculateScoreByFriends(friendsOfUser, friendsOfUsers.get(friendUser)));
            scoresOfUsers.put(friendUser, scoresOfUsers.get(friendUser) + CalculateScoreByVisitors(visitors, friendUser));
        }

        return scoresOfUsers.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .filter(u -> !u.equals(user))
                .limit(5)
                .collect(Collectors.toList());
    }

    /**
     * 해당 친구 관계로 두 유저의 친구 관계 업데이트
     *
     * @param friendsOfUser
     * @param relationship
     */
    private static void getFriendsOfUser(HashMap<String, ArrayList<String>> friendsOfUser, List<String> relationship) {
        ArrayList<String> friendList = friendsOfUser.getOrDefault(relationship.get(0), new ArrayList<>());
        friendList.add(relationship.get(1));
        friendsOfUser.put(relationship.get(0), friendList);

        friendList = friendsOfUser.getOrDefault(relationship.get(1), new ArrayList<>());
        friendList.add(relationship.get(0));
        friendsOfUser.put(relationship.get(1), friendList);
    }

    /**
     * 각 친구의 점수를 0으로 초기화
     *
     * @param scoresOfUser
     * @param relationship
     */
    private static void initializeScores(HashMap<String, Integer> scoresOfUser, List<String> relationship) {
        scoresOfUser.put(relationship.get(0), 0);
        scoresOfUser.put(relationship.get(1), 0);
    }

    /**
     * 사용자와 함께 아는 친구의 수로 점수 계산
     *
     * @param friendsOfUser
     * @param friendsOfFriendUser
     * @return 사용자와 함께 아는 친구의 수로 얻은 점수
     */
    private static int CalculateScoreByFriends(ArrayList<String> friendsOfUser, ArrayList<String> friendsOfFriendUser) {
        int score = 0;
        final int SCORE = 10;

        for (String friend : friendsOfFriendUser) {
            if (friendsOfUser.contains(friend)) {
                score += SCORE;
            }
        }

        return score;
    }

    /**
     * 사용자의 타임 라인에 방문한 횟수로 점수 계산
     *
     * @param visitors
     * @param friendUser
     * @return 사용자의 타임 라인에 방문한 횟수로 얻은 점수
     */
    private static int CalculateScoreByVisitors(List<String> visitors, String friendUser) {
        return Collections.frequency(visitors, friendUser);
    }
}
