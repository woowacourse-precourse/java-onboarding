package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 문제 7.
 * 1. 유저별 추천 점수 담을 수 있는 저장공간 생성
 * 2. 사용자의 친구 목록 추출
 * 3. friends를 통해 유저별 추천 점수 객체를 생성한다.
 * 4. 사용자의 친구와 친구인 유저들의 추천 점수 10점씩 증가
 * 5. 사용자의 SNS에 방문한 유저들의 추천 점수 1점씩 증가
 * 6. 점수가 가장 높은 순으로 정렬하여 최대 5명을 return(단, 0점과 본인 및 친구는 제외)
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> myFriends = getMyFriends(user, friends);
        Set<String> users = friends.stream().flatMap(List::stream).collect(Collectors.toSet());
        users.addAll(visitors);

        System.out.println(makeRecommendedScoreByUserListFromFriends(users));


        return answer;
    }

    private static List<String> getMyFriends(String user, List<List<String>> friends) {
        return friends.stream()
                .filter(friend -> friend.contains(user))
                .flatMap(List::stream)
                .filter(friend -> !friend.equals(user))
                .collect(Collectors.toList());
    }

    private static List<RecommendedScoreByUser> makeRecommendedScoreByUserListFromFriends(Set<String> users) {
        List<RecommendedScoreByUser> recommendedScoreByUserList = new java.util.ArrayList<>();

        for (String user : users) {
            recommendedScoreByUserList.add(new RecommendedScoreByUser(user));
        }

        return recommendedScoreByUserList;
    }

    private static class RecommendedScoreByUser {
        private String user;
        private int score;

        public RecommendedScoreByUser(String user) {
            this.user = user;
            this.score = 0;
        }

        public void addScoreByFriends(int count) {
            this.score += 10 * count;
        }

        public void addScoreByVisitors(int count) {
            this.score += count;
        }

        public String getUser() {
            return user;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return "RecommendedScoreByUser{" +
                    "user='" + user + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}
