package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Problem7 {
    public static class Score {
        String username;
        int score;

        public Score(String username, int score) {
            this.username = username;
            this.score = score;
        }

        public void addScore1() {
            this.score += 1;
        }

        public void addScore10() {
            this.score += 10;
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        PriorityQueue<Score> scorePriorityQueue = getScorePriorityQueue();
        return answer;
    }

    public static PriorityQueue<Score> getScorePriorityQueue() {
        return new PriorityQueue<>((a, b) -> (a.score == b.score) ?
                                            a.username.compareTo(b.username) : b.score-a.score);
    }
}
