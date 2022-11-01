package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 기능 목록
 * 1. 크루들의 정보를 저장할 Crew 클래스
 *      1. 점수를 10점 올리는 기능
 *      2. 점수를 1점 올리는 기능
 * 2. friends의 친구관계를 Crew에 넣고, 크루들을 team에 넣는 기능
 * 3. 함께 아는 친구일 경우, 10점을 부여하는 기능
 * 4. 타임라인에 방문한 경우, 1점을 부여하는 기능
 * 5. 점수가 가장 높은 기준으로 정렬하여 최대 5명의 친구가 추천되도록하는 기능
 */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static class Crew {
        String name;
        int score;
        List<String> friends = new ArrayList<>();

        public Crew(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public List<String> getFriends() {
            return friends;
        }

        public void plusScoreTen(){
            this.score += 10;
        }

        public void plusScoreOne() {
            this.score += 1;
        }
    }
}
