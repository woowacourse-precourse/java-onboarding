package onboarding;

import java.util.Collections;
import java.util.List;

/**
 * 문제 7.
 * 1. 유저별 추천 점수 담을 수 있는 저장공간 생성
 * 2. friends를 통해 유저별 추천 점수 객체를 생성한다.
 * 3. 사용자의 친구 목록 추출
 * 4. 사용자의 친구와 친구인 유저들의 추천 점수 10점씩 증가
 * 5. 사용자의 SNS에 방문한 유저들의 추천 점수 1점씩 증가
 *    - 이때, 생성 안 된 유저일 경우 새로 생성한다.
 * 6. 점수가 가장 높은 순으로 정렬하여 최대 5명을 return(단, 0점과 본인 및 친구는 제외)
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private class RecommendedScoreByUser {
        private String user;
        private int score;
        boolean isExcluded;

        public void RecommendedScore(String user) {
            this.user = user;
            this.score = 0;
            this.isExcluded = false;
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

        public boolean isExcluded() {
            return isExcluded;
        }
    }
}
