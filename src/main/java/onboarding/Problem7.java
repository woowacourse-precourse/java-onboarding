package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 기능 사항
 * 1. 추천할 친구 class 인 RecFriend 구현
 * 2. 친구 관계를 만드는 함수
 * 3. 친구 관계일 경우 10점을 추가하는 함수
 * 4. 방문자일 경우 1점을 추가하는 함수
 */
public class Problem7 {


    static HashMap<String, Set<String>> friendsHashMap = new HashMap<>();
    static HashMap<String, Integer> points = new HashMap<>();

    /**
     * 1. 추천할 친구 RecFriend class
     */
    static class RecFriend {
        private String name;
        private Integer score;

        RecFriend(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public Integer getScore() {
            return score;
        }

    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
