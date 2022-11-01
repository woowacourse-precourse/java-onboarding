package onboarding;

import java.util.*;

public class Problem7 {

    private static final int DUPLICATED_FRIENDS_SCORE = 10;
    private static final int VISITOR_SCORE = 1;
    private static final int MAX_SUGGESTION = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> nameAndScoreMap = new HashMap<>();

        List<String> friendsOfUser = getFriendsFrom(user, friends);

        // user, user의 친구는 제외
        List<String> excludes = new ArrayList<>();
        excludeUserAndFriendsOfUser(excludes, user, friendsOfUser);

        for (String friendOfUser : friendsOfUser) {
            //user의 친구의 친구
            List<String> friendsOfFriendsOfUser = getFriendsFrom(friendOfUser, friends);

            // 1) 함께 아는 친구 스코어 +10, (user, user의 친구는 제외)
            updateScore(nameAndScoreMap,
                    friendsOfFriendsOfUser,
                    excludes,
                    DUPLICATED_FRIENDS_SCORE);
        }

        // 2) 타임 라인 방문한 visitors 스코어 +1, (user, user의 친구는 제외)
        updateScore(nameAndScoreMap,
                visitors,
                excludes,
                VISITOR_SCORE);

        List<String> answer = Collections.emptyList();

        return answer;
    }

    private static void excludeUserAndFriendsOfUser(List<String> excludes, String user, List<String> friendsOfUser) {
        excludes.add(user);
        excludes.addAll(friendsOfUser);
    }

    // 첫 파라미터의 친구를 찾는 메서드
    private static List<String> getFriendsFrom(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);

            if (userA.equals(user)) {
                userFriends.add(userB);
            }
            if (userB.equals(user)) {
                userFriends.add(userA);
            }
        }

        return userFriends;
    }

    private static void updateScore(Map<String, Integer> nameAndScoreMap, List<String> includes, List<String> excludes, int fixedScore) {
        for (String name : includes) {
            if (excludes.contains(name)) {
                continue;
            }

            int score = nameAndScoreMap.getOrDefault(name, 0);
            nameAndScoreMap.put(name, score + fixedScore);
        }
    }

    private static List<Integer> getSortedScores(Map<String, Integer> nameAndScoreMap) {
        List<Integer> sortedScores = new ArrayList<>();
        for (int score : nameAndScoreMap.values()) {
            // 점수 중복을 제거
            if (sortedScores.contains(score)) {
                continue;
            }

            sortedScores.add(score);
        }

        Collections.sort(sortedScores, Collections.reverseOrder());

        return sortedScores;
    }

}
