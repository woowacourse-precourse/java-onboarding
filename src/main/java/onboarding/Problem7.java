package onboarding;

import problem7.Graph;
import problem7.Score;

import java.util.List;

public class Problem7 {
    private static Graph graph;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        return getAnswer(user, friends, visitors);
    }

    private static List<String> getAnswer(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        graph = new Graph(friends);

        Score score = new Score();
        score.scoring(user, graph.getAdjacentList(), visitors);
        answer = score.getTopFive();
        return answer;
    }
}
