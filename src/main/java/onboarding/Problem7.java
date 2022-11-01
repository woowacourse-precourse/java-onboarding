package onboarding;

import java.util.*;

public class Problem7 {

    public static final int MIN_USER_LENGTH = 1;
    public static final int MAX_USER_LENGTH = 30;

    public static final int MIN_FRIENDS_SIZE = 1;
    public static final int MAX_FRIENDS_SIZE = 10000;

    public static final int MAX_VISITORS_SIZE = 10000;

    public static final int RESULT_SIZE = 5;


    public static final int POINT_KNOW_SAME_FRIEND = 10;
    public static final int POINT_VISIT = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        if (isNotValidateUser(user) || isNotValidateFriends(friends) || isNotValidateVisitors(visitors)) {
            throw new IllegalArgumentException();
        }

        Set<String> userFriends = getUserFriends(user, friends);


        Map<String, Integer> recommendationScore = new HashMap<>();

        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            String scoredUser = null;
            if (userFriends.contains(user1) && !userFriends.contains(user2)) {
                scoredUser = user2;
            } else if (userFriends.contains(user2) && !userFriends.contains(user1)) {
                scoredUser = user1;
            }

            if (scoredUser != null) {
                raiseScore(recommendationScore, scoredUser, POINT_KNOW_SAME_FRIEND);
            }
        }


        for (String visitor : visitors) {
            if (!userFriends.contains(visitor)) {
                raiseScore(recommendationScore, visitor, POINT_VISIT);
            }
        }


        List<ScoreAndId> scoreAndIdList = new ArrayList<>();
        recommendationScore.forEach((id, score) ->
                scoreAndIdList.add(new ScoreAndId(score, id))
        );

        Collections.sort(scoreAndIdList);


        List<String> result = new ArrayList<>();
        for (int i = 0; i < RESULT_SIZE && i < scoreAndIdList.size(); i++) {
            result.add(scoreAndIdList.get(i).id);
        }

        return result;
    }

    private static Set<String> getUserFriends(String user, List<List<String>> friends) {

        Set<String> result = new HashSet<>();

        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if (friend1.equals(user)) {
                result.add(friend2);
            } else if (friend2.equals(user)) {
                result.add(friend1);
            }
        }

        // 자기 자신도 친구에 포함
        result.add(user);
        return result;
    }

    private static void raiseScore(Map<String, Integer> recommendationScore, String scoredUser, int point) {
        Integer score = recommendationScore.get(scoredUser);
        recommendationScore.put(scoredUser, score == null ? point : score + point);
    }

    private static boolean isNotValidateUser(String user) {
        // 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
        // 사용자 아이디는 길이가 1 이상 30 이하인 문자열이다.
        return !(MIN_USER_LENGTH <= user.length() && user.length() <= MAX_USER_LENGTH)
                || !(user.matches("^[a-z]*$"));
    }

    private static boolean isNotValidateFriends(List<List<String>> friends) {

        // friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
        if (!(MIN_FRIENDS_SIZE <= friends.size() && friends.size() <= MAX_FRIENDS_SIZE)) {
            return true;
        }

        Set<String> friendRelation = new HashSet<>();

        for (List<String> friend : friends) {

            // friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
            if (friend.size() != 2) return true;

            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            // 아이디 검증
            if (friend1.equals(friend2) || isNotValidateUser(friend1) || isNotValidateUser(friend2)) {
                return true;
            }

            // 동일한 친구 관계가 중복해서 주어지지 않는다.
            String relation = friend1.compareTo(friend2) < 0 ? friend1 + friend2 : friend2 + friend1;
            if (friendRelation.contains(relation)) {
                return true;
            }

            friendRelation.add(relation);
        }

        return false;
    }

    private static boolean isNotValidateVisitors(List<String> visitors) {
        // visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
        // 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
        return visitors.size() > MAX_VISITORS_SIZE
                || visitors.stream().anyMatch(Problem7::isNotValidateUser);
    }

    private static class ScoreAndId implements Comparable<ScoreAndId> {

        private final Integer score;
        private final String id;

        public ScoreAndId(Integer score, String id) {
            this.score = score;
            this.id = id;
        }

        @Override
        public int compareTo(ScoreAndId o) {
            if (!this.score.equals(o.score)) return -(this.score.compareTo(o.score));
            return this.id.compareTo(o.id);
        }
    }
}
