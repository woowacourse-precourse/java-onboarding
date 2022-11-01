package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 기능 목록
 * 1. 사용자와 함께 아는 친구의 수로 점수 계산
 * 2. 사용자의 타임 라인에 방문한 횟수로 점수 계산
 * 3. 총 점수 계산
 * 4. 3번을 이용해 최대 5명 목록 구하기
 */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scoresOfUsers;
        HashMap<String, ArrayList<String>> friendsOfUsers = new HashMap<>();

        for (List<String> relationship : friends) {
            getFriendsOfUser(friendsOfUsers, relationship);
        }

        final ArrayList<String> friendsOfUser = friendsOfUsers.get(user);
        scoresOfUsers = calculateScore(friendsOfUsers, friendsOfUser, visitors);

        return getAnswerList(scoresOfUsers.entrySet().stream(), friendsOfUser, user);
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
     * 사용자와 함께 아는 친구의 수로 점수 계산
     *
     * @param friendsOfUser
     * @param friendsOfFriendUser
     * @return 사용자와 함께 아는 친구의 수로 얻은 점수
     */
    private static int calculateScoreByFriends(ArrayList<String> friendsOfUser, ArrayList<String> friendsOfFriendUser) {
        int score = 0;
        final int SCORE = 10;

        if (friendsOfUser == null) {
            return 0;
        }

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
    private static int calculateScoreByVisitors(List<String> visitors, String friendUser) {
        return Collections.frequency(visitors, friendUser);
    }

    /**
     * 유저들의 점수 계산
     *
     * @param friendsOfUsers
     * @param friendsOfUser
     * @param visitors
     * @return (유저, 점수)의 hashMap
     */
    private static HashMap<String, Integer> calculateScore(HashMap<String, ArrayList<String>> friendsOfUsers, ArrayList<String> friendsOfUser, List<String> visitors) {
        HashMap<String, Integer> scoresOfUsers = new HashMap<>();

        for (String friendUser : friendsOfUsers.keySet()) {
            scoresOfUsers.put(friendUser, calculateScoreByFriends(friendsOfUser, friendsOfUsers.get(friendUser)));
        }
        for (String visitor : visitors) {
            scoresOfUsers.put(visitor, calculateScoreByVisitors(visitors, visitor));
        }

        return scoresOfUsers;
    }

    /**
     * 점수들을 바탕으로 친구 추천 결과를 반환
     *
     * @param stream
     * @param friendsOfUser
     * @param user
     * @return 추천 친구 리스트
     */
    private static List<String> getAnswerList(Stream<Map.Entry<String, Integer>> stream, List<String> friendsOfUser, String user) {
        if (friendsOfUser != null) {
            stream = stream.filter(e -> !friendsOfUser.contains(e.getKey()));
        }

        Comparator<Map.Entry<String, Integer>> compare
                = Comparator
                .comparing(Map.Entry<String, Integer>::getValue).reversed()
                .thenComparing(Map.Entry::getKey);

        return stream
                .filter(e -> e.getValue() > 0 && !e.getKey().equals(user))
                .sorted(compare)
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }
}
