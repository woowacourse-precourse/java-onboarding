package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    // 추천 친구와 점수를 기록하기 위한 클래스
    private static class FriendCount {
        String name;
        int count;

        FriendCount(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
}